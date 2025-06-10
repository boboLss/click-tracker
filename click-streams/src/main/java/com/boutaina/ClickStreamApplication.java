package com.boutaina;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ClickStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickStreamApplication.class, args);
    }

    @Bean
    public KStream<String, String> kStream(StreamsBuilder builder) {
        KStream<String, String> stream = builder.stream("clicks");

        stream
                .groupByKey()
                .count(Materialized.as("clicks-count-store"))
                .toStream()
                .mapValues(Object::toString)
                .to("click-counts", Produced.with(Serdes.String(), Serdes.String()));

        return stream;
    }
}

