package cm.enspy.gi.project.localisation_service.models;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="app_point")
final public class AppPoint {
    
    @Id 
	@Column(name="point_id", updatable=false) 
    @JsonProperty(access= JsonProperty.Access.READ_ONLY) 
	private UUID pointId;

    private String locationLabel;

    private String description;

    @Enumerated(value=EnumType.STRING)
    private AppPointType type;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @Column(name="add_at", updatable=false)
    private LocalDateTime addAt;
	

    @Column(columnDefinition = "geometry(Point,4326)", updatable=false)
    //@Type(value =  org.locationtech.jts.geom.Geometry.class)
    private Point point;

    @ElementCollection
    private Set<String> pictures_paths;
    
}




