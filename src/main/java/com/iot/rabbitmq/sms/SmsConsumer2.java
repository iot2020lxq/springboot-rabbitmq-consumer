package com.iot.rabbitmq.sms;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
@RabbitListener(queues="smsQueue_topic")
public class SmsConsumer2 {

	@RabbitHandler
	public void process(String msg) {
		System.out.println("短信消费者2消费消息："+msg);
	}
}
