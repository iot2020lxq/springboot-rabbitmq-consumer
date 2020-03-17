package com.iot.rabbitmq.sms;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*@Component
@RabbitListener(queues="sms_queue")
public class SmsConsumer {

	@RabbitHandler
	public void process(String msg) {
	
		System.out.println("短信消费者消费消息："+msg);
		
		int i = 1/0;
		try {
			//设置手动应答模式
			channel.basicAck(msg.getMessageProperties().getDeliveryTag(), false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}*/
