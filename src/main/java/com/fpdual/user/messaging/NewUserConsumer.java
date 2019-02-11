package com.fpdual.user.messaging;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fpdual.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NewUserConsumer {

	private static final String MSG_TOPIC_CONSUMER_NEW_USER = "NewUser topic consumed";

	@KafkaListener(topics = "new_user")
	public void receiveNewUser(ConsumerRecord<MessageTopic, User> consumerRecord) {
		log.info(MSG_TOPIC_CONSUMER_NEW_USER, consumerRecord.value());
	}

}
