
package cm.enspy.gi.project.localisation_service.repositories;

 
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cm.enspy.gi.project.localisation_service.models.AppPoint; 
 

public interface AppPointRepository extends JpaRepository<AppPoint, UUID> {
  
    //TODO

}

