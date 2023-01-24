package cm.enspy.gi.project.localisation_service.listener;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserPointRequest {

    private String userId;

    private Boolean isTripPosition;

    private float lon;

    private float lat;
    
}
