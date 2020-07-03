package net.ketone.scdf.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.ketone.scdf.dto.Diu;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

import java.io.IOException;

@EnableBinding(Processor.class)
@Slf4j
public class ProcessorConfiguration {

        private ObjectMapper objectMapper = new ObjectMapper();

       @Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
        public String convertToPojo(byte[] payload) {
           log.info("lol size=" + payload.length);
           try {
               Diu diu = objectMapper.readValue(payload, Diu.class);
               log.info("gotcha! " + diu.getDiu());
               return diu.getDiu();
           } catch (IOException e) {
               log.error("Err", e);
           }
           return "diu!";
        }

}