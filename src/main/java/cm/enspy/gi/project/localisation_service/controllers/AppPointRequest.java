package cm.enspy.gi.project.localisation_service.controllers;

 
import java.util.Set;

import cm.enspy.gi.project.localisation_service.models.AppPointType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data 
final public class AppPointRequest {
    

    private String locationLabel;

    private AppPointType type;

    private String description;

    private Float lon;

    private Float lat;
	
    private Set<String> pictures_paths;
    
}




