package com.iot.rabbitmq.email;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

/*@Component
@RabbitListener(queues="email_queue")
public class EmailConsumer {

	@RabbitHandler
	public void process(String msg) {
		
		System.out.println("邮件消费者消费消息："+msg);
		try {
			//设置手动应答模式
			channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}*/
