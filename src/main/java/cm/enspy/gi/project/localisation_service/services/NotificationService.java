/* package enspy.gi.project.reservation_service.services;



import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import enspy.gi.project.reservation_service.models.Notification;
import enspy.gi.project.reservation_service.models.NotificationReason;


@Service
public class NotificationService {

    @Autowired
    Producer<Notification> producer;


    public MessageId sendFailedReservation(String userId, String tripId, NotificationReason reason) throws PulsarClientException {

        //TODO
        
        Notification notification = new Notification();
        

        return producer.send(notification);
        
    }

    public MessageId sendSuccessReservation(String userId, String tripId, String reservId) throws PulsarClientException  {


        //TODO

        Notification notification = new Notification();
        

        return producer.send(notification);
        
    }
    
}



 */