package io.spring.dataflow.sample.usagedetailsender;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.CompositeMessageConverter;
import org.springframework.messaging.converter.MessageConverter;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class UsageDetailSenderKafkaApplicationTests {

	@Test
	public void testUsageDetailSender() {

		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(
				TestChannelBinderConfiguration
						.getCompleteConfiguration(UsageDetailSenderKafkaApplication.class))
				.web(WebApplicationType.NONE)
				.run()) {

			OutputDestination target = context.getBean(OutputDestination.class);
			Message<byte[]> sourceMessage = target.receive(10000);

			final MessageConverter converter = context.getBean(CompositeMessageConverter.class);
			UsageDetail usageDetail = (UsageDetail) converter
					.fromMessage(sourceMessage, UsageDetail.class);

			assertThat(usageDetail.getId()).isBetween(0, 15_000);
			assertThat(usageDetail.getData()).isNotBlank();
			assertThat(usageDetail.getDuration()).isBetween(1, 2000);
			log.info("event:{}",usageDetail);
		}
	}
}
