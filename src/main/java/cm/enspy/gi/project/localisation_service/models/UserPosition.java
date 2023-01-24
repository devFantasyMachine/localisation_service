package cm.enspy.gi.project.localisation_service.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
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
public class UserPosition {
    
    @Id 
	@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
	private long id;

    private String userId;

    private Boolean isTripPosition;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point point;
    
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @OrderBy
    private LocalDateTime at;


}


