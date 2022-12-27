package cm.enspy.gi.project.localisation_service.models;


import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table
public class Alarm {

    @Id 
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
	private long id;

    private String userId;

    private boolean isEnabled;

    private AlarmType type;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point point; // l'alarme est definie sur un point (point depart, point arrivee,point arret)

    private float distance; // declanche a une distance de "distance" autour du point "point"

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private LocalDateTime addAt;
    
    private LocalDateTime at; // la date a partir de laquelle l'alarm est active

   
}





