# Simple Kafka Message Processor

## Pipeline

Processor
maven://net.ketone:scdf-spring-processor:0.0.5-SNAPSHOT

Stream
http --port=20002 | scdf-processor | log

## Run

POST http://localhost:20002 with contents to be sent
