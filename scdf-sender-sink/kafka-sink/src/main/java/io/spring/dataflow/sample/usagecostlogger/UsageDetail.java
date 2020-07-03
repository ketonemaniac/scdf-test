package io.spring.dataflow.sample.usagecostlogger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UsageDetail {
    private int id;
    private String data;
    private int duration;
}
