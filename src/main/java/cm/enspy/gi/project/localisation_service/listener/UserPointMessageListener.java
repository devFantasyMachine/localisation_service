/* package cm.enspy.gi.project.localisation_service.listener;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 
import lombok.extern.slf4j.Slf4j;

 
@Component
@Slf4j
public class UserPointMessageListener implements MessageListener<UserPointRequest> {


    @Autowired
    ReservationService reservationService;


    @Override
    public void received(Consumer<UserPointRequest> consumer, Message<UserPointRequest> msg) {
        try {
            log.info("Topic Name: {}", msg.getTopicName());
            log.info("Message Id: {}", msg.getMessageId());
            log.info("Producer Name: {}", msg.getProducerName());
            log.info("Publish Time: {}", msg.getPublishTime());

            log.info("Message received: {}", new String(msg.getData()));
            
            reservationService.applyReservationRequest(msg.getValue());           

            consumer.acknowledge(msg.getMessageId());                   

        } catch (Exception e) {

            consumer.negativeAcknowledge(msg.getMessageId());
        }
    }
} */