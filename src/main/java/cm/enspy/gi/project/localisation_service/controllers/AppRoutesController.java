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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cm.enspy.gi.project.localisation_service.models.AppPoint;
import cm.enspy.gi.project.localisation_service.models.AppRoute;
import cm.enspy.gi.project.localisation_service.repositories.AppPointRepository;
import cm.enspy.gi.project.localisation_service.repositories.AppRouteRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/v0/routes")
public class AppRoutesController {

    @Autowired
    AppRouteRepository routeRepository;

    @PostMapping(value = "/add")
    public ResponseEntity<AppRoute> addAppRoute(@RequestBody AppRoute request) {

        request.setAddAt(LocalDateTime.now());
        request.setRouteId(UUID.randomUUID());

        return ResponseEntity.ok(routeRepository.save(request));
    }

    @PostMapping(value = "/add-point/{routeId}")
    public ResponseEntity<AppRoute> addAppPointInAppRoute(@PathVariable UUID routeId, @RequestParam(required=false) Integer pos,  @RequestBody AppPoint request) {

        
        Optional<AppRoute> optRoute =  routeRepository.findById(routeId);

        if(optRoute.isEmpty())return ResponseEntity.notFound().build();

        AppRoute route =  optRoute.get();

        if(pos == null){

            route.getPoints().add(request);
        }
        else{

            route.getPoints().add(pos, request);
        }

        //request.setRouteId(UUID.randomUUID());

        return ResponseEntity.ok(routeRepository.save(route));
    }


    @PutMapping(value = "/change-description/{routeId}")
    public ResponseEntity<AppRoute> changeDescription(@PathVariable UUID routeId,  @RequestBody String newDesc) {


        Optional<AppRoute> optRoute =  routeRepository.findById(routeId);

        if(optRoute.isEmpty())return ResponseEntity.notFound().build();

        AppRoute route =  optRoute.get();

        route.setDescription(newDesc);

        return ResponseEntity.ok(routeRepository.save(route));
    }


    @PutMapping(value = "/change-label/{routeId}")
    public ResponseEntity<AppRoute> changeLabel(@PathVariable UUID routeId,  @RequestBody String newLabel) {


        Optional<AppRoute> optRoute =  routeRepository.findById(routeId);

        if(optRoute.isEmpty())return ResponseEntity.notFound().build();

        AppRoute route = optRoute.get();

        route.setLabel(newLabel);

        return ResponseEntity.ok(routeRepository.save(route));
    }
 

    @GetMapping(value = "/{pointId}")
    public ResponseEntity<AppRoute> getAppRouteById(@PathVariable UUID routeId) {

        return ResponseEntity.of(routeRepository.findById(routeId));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<AppRoute>> getAllAppRoute() {

        return ResponseEntity.ok(routeRepository.findAll());
    }

    @GetMapping(value = "/label/{label}")
    public ResponseEntity<List<AppRoute>> getAllAppRouteByLabel(@PathVariable String label) {

        return ResponseEntity.ok(routeRepository.findAllByLabelLike(label));
    }

}
