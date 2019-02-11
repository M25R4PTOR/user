package com.fpdual.user.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fpdual.user.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class UserMsgProducer {

	private KafkaTemplate<MessageTopic, User> kafkaTemplate;

	public void sendMessage(MessageTopic topic, User user) {
		kafkaTemplate.send(topic.toString(), user);
		log.info("Kafka producer: message with topic {} sent: {}", topic.toString(), user);
	}
}
