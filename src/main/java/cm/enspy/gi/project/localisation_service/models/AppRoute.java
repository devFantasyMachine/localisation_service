package cm.enspy.gi.project.localisation_service.models;

import java.util.Map;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="app_route")
public class AppRoute {
    
    @Id 
	@Column(name="id")
	private Long id;

    private String label;

    private String description;
	

    //private Map<Integer, AppPoint> points;
    
}




