
package cm.enspy.gi.project.localisation_service.repositories;

 
import java.util.List;
import java.util.UUID;
 
import org.springframework.data.jpa.repository.JpaRepository;
 
import cm.enspy.gi.project.localisation_service.models.AppRoute;
 
 
public interface AppRouteRepository extends JpaRepository<AppRoute, UUID> {
  
    //TODO

    List<AppRoute> findAllByLabelLike(String label);

}

