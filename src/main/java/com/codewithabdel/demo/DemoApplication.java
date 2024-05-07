package com.codewithabdel.demo;

import com.codewithabdel.demo.entity.FakeEntity;
import com.codewithabdel.demo.producer.KafkaProducer;
import com.codewithabdel.demo.repository.FakeEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

	@Autowired
	KafkaProducer kafkaProducer;

	@Autowired
	FakeEntityRepository fakeEntityRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MyEvent event = MyEvent.builder().key("test message 2").build();
		kafkaProducer.sendFlightEvent(event);

		FakeEntity entity = FakeEntity.builder().name("test entity").build();
		fakeEntityRepository.save(entity);
		log.info("saved successfully");
	}
}
