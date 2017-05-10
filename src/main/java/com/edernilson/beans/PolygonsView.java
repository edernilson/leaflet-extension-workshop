package com.edernilson.beans;

import com.edernilson.componentes.model.leaflet.DefaultMapModel;
import com.edernilson.componentes.model.leaflet.LatLng;
import com.edernilson.componentes.model.leaflet.MapModel;
import com.edernilson.componentes.model.leaflet.Polygon;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eder.nilson
 */
@ManagedBean
public class PolygonsView implements Serializable {
  
    private MapModel polygonModel;
      
    @PostConstruct
    public void init() {
        polygonModel = new DefaultMapModel();
          
        LatLng coord1 = new LatLng(36.879466, 30.667648);
        LatLng coord2 = new LatLng(36.883707, 30.689216);
        LatLng coord3 = new LatLng(36.879703, 30.706707);
  
        //Polygon
        Polygon polygon = new Polygon();
        polygon.getPaths().add(coord1);
        polygon.getPaths().add(coord2);
        polygon.getPaths().add(coord3);
  
        polygon.setStrokeColor("#FF0000");
        polygon.setFillColor("#FF9900");
        polygon.setStrokeOpacity(0.7);
        polygon.setFillOpacity(0.7);
          
        polygonModel.addOverlay(polygon);
    }
  
    public MapModel getPolygonModel() {
        return polygonModel;
    }
  
}