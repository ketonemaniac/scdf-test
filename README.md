# SCDF Streams on Docker

## Startup

Download docker-compose.yml

    wget https://raw.githubusercontent.com/spring-cloud/spring-cloud-dataflow/v2.5.1.RELEASE/spring-cloud-dataflow-server/docker-compose.yml

Export the following (or put it in your .bash_profile). __The HOST_MOUNT_PATH has to be .m2 instead of .m2/repository as suggested in the yml__
  

    export HOST_MOUNT_PATH=/Users/<your_name>/.m2
    export DOCKER_MOUNT_PATH=/root/.m2/

Run 

    DATAFLOW_VERSION=2.5.1.RELEASE SKIPPER_VERSION=2.4.1.RELEASE docker-compose up --no-recreate


docker stop $(docker ps -a -q)

docker rm $(docker ps -a -q)


Skipper Shell
docker run --name spring-cloud-skipper-shell bitnami/spring-cloud-skipper-shell:latest

## Run

SCDF UI
http://localhost:9393/dashboard/#/streams/definitions/


## Debug
1. Find the runtime log file in SCDF UI's runtime section
2. tail the logs using the docker command:


    docker exec -it skipper tail -f <log_name>
    


## References
Installation and setup
https://dataflow.spring.io/docs/installation/local/docker/

SCDF Processor Sample
https://www.baeldung.com/spring-cloud-data-flow-etl

Kafka Producer and Consumer
https://dataflow.spring.io/docs/stream-developer-guides/streams/standalone-stream-kafka/


