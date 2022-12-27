package cm.enspy.gi.project.localisation_service.models;

import java.util.Set;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.vividsolutions.jts.geom.Point;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="app_point")
public class AppPoint {
    
    @Id 
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String label;

    private String description;
	

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point point;

    //private Set<String> pictures_paths;
    
}




