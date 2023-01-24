package cm.enspy.gi.project.localisation_service.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cm.enspy.gi.project.localisation_service.models.Itinerary; 
import cm.enspy.gi.project.localisation_service.repositories.ItineraryRepository;
import cm.enspy.gi.project.localisation_service.repositories.AppRouteRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v0/itineraries")
public class ItineraryController {

    @Autowired
    AppRouteRepository routeRepository;

    @Autowired
    ItineraryRepository itineraryRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<Itinerary> addItinerary(@RequestBody Itinerary request) {

        request.setAddAt(LocalDateTime.now()); 

        return ResponseEntity.ok(itineraryRepository.save(request));
    }

    @PutMapping(value = "/change-cost/{id}")
    public ResponseEntity<Itinerary> changeStandardCost(@PathVariable UUID id, @RequestBody Float newCost) {

        Optional<Itinerary> opt = itineraryRepository.findById(id);

        if (opt.isEmpty())
            return ResponseEntity.notFound().build();

        Itinerary itinerary = opt.get();

        itinerary.setStandardCost(newCost);

        return ResponseEntity.ok(itineraryRepository.save(itinerary));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable UUID id) {

        return ResponseEntity.of(itineraryRepository.findById(id));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Itinerary>> getAllItinerary() {

        return ResponseEntity.ok(itineraryRepository.findAll());
    }



}
