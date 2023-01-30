package cm.enspy.gi.project.localisation_service.models;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType; 
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name="itinerary")
public class Itinerary {
    
    @Id 
	@Column(name="itinerary_id", updatable=false) 
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
	private UUID itineraryId;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @Column(name="add_at", updatable=false)
    private LocalDateTime addAt;

    @Column(name="start_city", updatable=false)
    private String startCity;

    @Column(name="destination_city", updatable=false)
    private String destinationCity;

    private Float standardCost;

    private String note;

    private Boolean isAvailable;
	
    @ManyToOne(optional=false, fetch = FetchType.EAGER)
    private AppRoute route;


    @ElementCollection
    private Set<String> pictures_paths;
    
}




