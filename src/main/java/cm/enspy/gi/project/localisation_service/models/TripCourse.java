package cm.enspy.gi.project.localisation_service.models;



import java.time.LocalDateTime; 
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name="trip_course") 
@Table(name="trip_course") 
public class TripCourse {

    @Id 
	@Column(name="course_id")
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
	private UUID courseId;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private LocalDateTime addAt;
    
    private LocalDateTime at; // la date du voyage

    @OneToMany(cascade= CascadeType.ALL, mappedBy="tripCourse")
    Set<Alarm> alarms;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="itinerary_id", nullable=false, updatable=false)
    private Itinerary itinerary;


    
}


