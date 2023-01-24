package cm.enspy.gi.project.localisation_service.models;

import java.time.LocalDateTime;
import java.util.ArrayList; 
import java.util.List; 
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="app_route")
public class AppRoute {
    
    @Id 
	@Column(name="route_id", updatable=false)
    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
	private UUID routeId;

    private String label;

    private String description;

    @Column(columnDefinition = "geometry(Point,4326)", updatable=false)
    private Point point;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @Column(name="add_at", updatable=false)
    private LocalDateTime addAt;

    @Transient
    private LineString route;
	
    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER)
    @OrderColumn(name = "points_order")
    private List<AppPoint> points = new ArrayList<>();



    public AppPoint getStartPoint(){

        return points.get(0);

    }

    public AppPoint getDestinationPoint(){

        return points.get(points.size());
        
    }
    
}




