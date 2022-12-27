/* 
package enspy.gi.project.reservation_service.services;

import java.util.ArrayList;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import enspy.gi.project.reservation_service.models.Reservation;
import enspy.gi.project.reservation_service.models.ReservationRequest;
import enspy.gi.project.reservation_service.models.ReservationRequestAction;
import enspy.gi.project.reservation_service.repository.ReservationRepository;


 
@Service
public class ReservationService {

    @Autowired
    NotificationService notificationService;

    @Autowired
    TripService tripService;

    @Autowired
    PayementService payementService;

    @Autowired
    ReservationRepository reservationRepository;


    public void applyReservationRequest(ReservationRequest request) throws Exception {

        if(request.getAction() == ReservationRequestAction.CREATE){

            createReservation(request.getUserId(), request.getTripId(), request.getPlaces(), request.getCredentialPayement());            

        }
        else if (request.getAction() == ReservationRequestAction.CANCEL) {
            
            cancelReservation(request.getReservationId());

        }
        else{

            throw new Exception("UNKNOW ACTION");
        }
    
    }


    //

    @Cacheable(value = "reservations", key = "#reservId")
    public Reservation createReservation(String userId, String tripId, int[] places, String credential) {
        return null;

        //TODO
    
    }


    @CachePut(value = "reservations", key = "#reservation.reservId")
    public Reservation cancelReservation(String uuid) {
        return null;

        //TODO
    
    }




    @Cacheable(value = "reservations", key = "#reservId")
    public Reservation getReservationById(String id) {
        
        return null;
        
    }


    @Cacheable(value = "reservations", key = "#tripId")
    public List<Reservation> getAllReservationByTripId(String tripId) {
        
        return null;
        
    }

    @Cacheable(value = "reservations", key = "getReservations")
    public List<Reservation> getAllReservation() {
        
        return new ArrayList<>();
        
    }


    @CacheEvict(value = "reservations", allEntries=true)
    public Boolean deleteReservation(String reservId) {
        return null;
    }


    @CacheEvict(value = "reservations", allEntries=true)
    public Reservation terminateReservation(String reservId) {
        return null;
    }

    
}











 */