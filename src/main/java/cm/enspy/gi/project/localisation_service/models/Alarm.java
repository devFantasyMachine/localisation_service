package cm.enspy.gi.project.localisation_service.models;


import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty; 

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
	@Column(name="alarm_id") 
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
	private UUID alarmId;

    @Column(name="user_id") 
    private String userId;

    private boolean isEnabled;

    @Enumerated(value=EnumType.STRING)
    private AlarmType type;

    @ManyToOne(optional=false) 
    @JoinColumn(nullable=false, updatable=false)
    private AppPoint point; // l'alarme est definie sur un point (point depart, point arrivee,point arret)

    private float distance; // declanche a une distance de "distance" autour du point "point"

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private LocalDateTime addAt;
    
    private LocalDateTime at; // la date a partir de laquelle l'alarm est active

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false)
    private TripCourse tripCourse;

   
}





