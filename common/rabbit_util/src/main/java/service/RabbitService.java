package service;


import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class RabbitService {

    /*
    映入rabbitmq 模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param exchange  交换机
     * @param routingKey    路由键
     * @param message   消息
     * @return
     */
    public boolean sendMessage(String exchange,String routingKey,Object message){
        //  调用发送数据的方法
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
        return true;
    }
    /**
     * 发送延迟消息
     * @param exchange  交换机
     * @param routingKey    路由键
     * @param message   消息
     * @param delayTime 延迟时间
     * @return
     */
    public boolean sendDelayMessage(String exchange,String routingKey,Object message, int delayTime){
        rabbitTemplate.convertAndSend(exchange, routingKey, message, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //  设置一个延迟时间
                message.getMessageProperties().setDelay(delayTime * 1000);
                return message;
            }
        });
        return true;
    }

}
