package cm.enspy.gi.project.localisation_service.config;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.MessageListener;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;
import org.apache.pulsar.client.api.SubscriptionType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cm.enspy.gi.project.localisation_service.models.Notification;
import lombok.SneakyThrows;

@Configuration
public class PulsarConfig {


    @Value("${pulsar.service.url:pulsar://localhost:6650}")
    String pulsarUrl;

    @Value("${pulsar.service.notification.topic:notification_topic}")
    String notification_topic;

    @Value("${pulsar.service.producer_name:notification_producer}")
    String producer_name;

    //
    @Value("${pulsar.service.reservation.topic:reservation_topic}")
    String reservation_topic;

    @Value("${pulsar.service.subscription_name:reservation_consumer}")
    String subscription_name;

    @SneakyThrows
    @Bean
    public PulsarClient buildClient() {
        PulsarClient client = PulsarClient.builder()
                .serviceUrl(pulsarUrl)
                .build();
        return client;
    }


    @Bean
    public Producer<Notification> producer(PulsarClient client) throws PulsarClientException {
        
        return client.newProducer(Schema.AVRO(Notification.class))
                .topic(notification_topic)
                .producerName(producer_name)
                .create();
    }


      @Bean
    public Consumer<ReservationRequest> consumer(PulsarClient client,
                                          MessageListener<ReservationRequest> reservationMessageListener) throws PulsarClientException {
        
        return client.newConsumer(Schema.AVRO(ReservationRequest.class))
                .topic(reservation_topic)
                .subscriptionType(SubscriptionType.Shared)
                .subscriptionName(subscription_name)
                .messageListener(reservationMessageListener)
                .subscribe();
    }  

}




  