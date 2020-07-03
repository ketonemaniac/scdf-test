package io.spring.dataflow.sample.usagedetailsender;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
public class UsageDetailSender {

    @Bean
    public Supplier<UsageDetail> sendEvents() {
        return () -> UsageDetail.builder()
                .data(RandomStringUtils.randomAlphabetic(100))
                .duration(RandomUtils.nextInt(1, 2000))
                .id(RandomUtils.nextInt(0, 15_000))
                .build();
    }
}
