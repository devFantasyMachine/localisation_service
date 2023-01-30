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

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

import cm.enspy.gi.project.localisation_service.models.AppPoint;
import cm.enspy.gi.project.localisation_service.repositories.AppPointRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v0/points")
public class AppPointController {

    private GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    @Autowired
    AppPointRepository pointRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<AppPoint> addAppPoint(@RequestBody AppPointRequest request) {

        Point p = factory.createPoint(new Coordinate(request.getLon(), request.getLat()));

        AppPoint appPoint = AppPoint.builder()
                                .pointId(UUID.randomUUID())
                                .addAt(LocalDateTime.now())
                                .description(request.getDescription())
                                .locationLabel(request.getLocationLabel())
                                .type(request.getType())
                                .point(p)
                                .build();

        return ResponseEntity.ok(pointRepository.save(appPoint));
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
