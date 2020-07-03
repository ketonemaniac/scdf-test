package io.spring.dataflow.sample.usagecostlogger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;
import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import java.util.HashMap;

//@ExtendWith(OutputCaptureExtension.class)
public class UsageCostLoggerKafkaApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUsageCostLogger() throws JsonProcessingException {
        try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
                TestChannelBinderConfiguration
                        .getCompleteConfiguration(UsageCostLoggerKafkaApplication.class))
                .web(WebApplicationType.NONE)
                .run()) {

            InputDestination source = context.getBean(InputDestination.class);

            UsageDetail usageCostDetail = UsageDetail.builder()
                    .id(1)
                    .data("Data1")
                    .duration(5)
                    .build();

            final MessageConverter converter = context.getBean(CompositeMessageConverter.class);
            val headers = new HashMap<String, Object>();
            headers.put("contentType", "application/json");
            MessageHeaders messageHeaders = new MessageHeaders(headers);
            final Message<?> message = converter.toMessage(usageCostDetail, messageHeaders);

            source.send(message);
//            val s = new ObjectMapper().writeValueAsString(usageCostDetail);
//            Awaitility.await().until(output::getOut, value -> value.contains(s));
        }
    }
}
