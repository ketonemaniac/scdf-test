package io.spring.dataflow.sample.usagecostlogger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class UsageLogger {

    @Bean
    public Consumer<UsageDetail> process() {
        return usageDetail -> {
            log.info("Receive {}", usageDetail);
        };
    }
}
