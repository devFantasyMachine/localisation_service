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

import cm.enspy.gi.project.localisation_service.models.AppPoint;
import cm.enspy.gi.project.localisation_service.repositories.AppPointRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v0/points")
public class AppPointController {

    @Autowired
    AppPointRepository pointRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<AppPoint> addAppPoint(@RequestBody AppPoint request) {

        request.setAddAt(LocalDateTime.now());

        return ResponseEntity.ok(pointRepository.save(request));
    }


    @PutMapping(value = "/change-description/{pointId}")
    public ResponseEntity<AppPoint> changeDescription(@PathVariable UUID pointId,  @RequestBody String newDesc) {


        Optional<AppPoint> optPoint =  pointRepository.findById(pointId);

        if(optPoint.isEmpty())return ResponseEntity.notFound().build();

        AppPoint point =  optPoint.get();

        point.setDescription(newDesc);

        return ResponseEntity.ok(pointRepository.save(point));
    }


    @PutMapping(value = "/change-label/{pointId}")
    public ResponseEntity<AppPoint> changeLabel(@PathVariable UUID pointId,  @RequestBody String newLabel) {


        Optional<AppPoint> optPoint =  pointRepository.findById(pointId);

        if(optPoint.isEmpty())return ResponseEntity.notFound().build();

        AppPoint point =  optPoint.get();

        point.setLocationLabel(newLabel);

        return ResponseEntity.ok(pointRepository.save(point));
    }
 

    @GetMapping(value = "/{pointId}")
    public ResponseEntity<AppPoint> getAppPointById(@PathVariable UUID pointId) {

        return ResponseEntity.of(pointRepository.findById(pointId));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<AppPoint>> getAllAppPoint() {

        return ResponseEntity.ok(pointRepository.findAll());
    }

}
