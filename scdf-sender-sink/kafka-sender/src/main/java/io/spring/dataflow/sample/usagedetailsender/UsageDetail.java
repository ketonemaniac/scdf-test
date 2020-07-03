package io.spring.dataflow.sample.usagedetailsender;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class UsageDetail {
    private int id;
    private String data;
    private int duration;
}
