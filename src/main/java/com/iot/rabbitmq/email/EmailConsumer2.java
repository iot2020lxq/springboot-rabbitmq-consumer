package com.iot.rabbitmq.email;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

@Component
public class EmailConsumer2 {
	
	//建立关系，对消息进行监听，还能帮我们创建这些exchange，queue
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value="emailQueue_topic",durable="true"),
			exchange = @Exchange(value="TOPIC_EXCHANGE",durable="true",type="topic",
				ignoreDeclarationExceptions="true"),
			key = "topicEmail.#"
			)
	)
	@RabbitHandler
	public void process(Message message,Channel channel) throws Exception {
		System.err.println("------------------------------------");
		System.err.println("邮件消费者消费消息："+message.getPayload());
		try {
			//设置手动应答模式
			Long deliveryTag = (Long)message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
			channel.basicAck(deliveryTag, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* --------------------------------------------------------------------------------- */
	
	//建立关系，对消息进行监听，还能帮我们创建这些exchange，queue
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue(value = "${spring.rabbitmq.listener.order.queue.name}", 
			durable="${spring.rabbitmq.listener.order.queue.durable}"),
			exchange = @Exchange(value = "${spring.rabbitmq.listener.order.exchange.name}", 
			durable="${spring.rabbitmq.listener.order.exchange.durable}", 
			type= "${spring.rabbitmq.listener.order.exchange.type}", 
			ignoreDeclarationExceptions = "${spring.rabbitmq.listener.order.exchange.ignoreDeclarationExceptions}"),
			key = "${spring.rabbitmq.listener.order.key}"
			)
	)
	@RabbitHandler
	public void process(@Payload com.iot.rabbitmq.entity.Order order,Channel channel,
			@Headers Map<String,Object> headers) throws Exception {
		System.err.println("------------------------------------");
		System.err.println("邮件消费者消费消息绑定Order："+order.getId());
		try {
			//设置手动应答模式
			Long deliveryTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
			channel.basicAck(deliveryTag, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
