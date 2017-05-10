package com.edernilson.beans;

import com.edernilson.componentes.event.leaflet.MarkerDragEvent;
import com.edernilson.componentes.model.leaflet.DefaultMapModel;
import com.edernilson.componentes.model.leaflet.LatLng;
import com.edernilson.componentes.model.leaflet.MapModel;
import com.edernilson.componentes.model.leaflet.Marker;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author eder.nilson
 */
@ManagedBean
@ViewScoped
public class DraggableMarkersView implements Serializable {
  
    private MapModel draggableModel;
     
    private Marker marker;
     
    @PostConstruct
    public void init() {
        draggableModel = new DefaultMapModel();
          
        //Shared coordinates
        LatLng coord1 = new LatLng(-3.734489, -38.5600023);
        LatLng coord2 = new LatLng(-3.7492242, -38.531305);
          
        //Draggable
        draggableModel.addOverlay(new Marker(coord1, "Eder Nilson"));
        draggableModel.addOverlay(new Marker(coord2, "ViaSoluTI"));
          
        for(Marker premarker : draggableModel.getMarkers()) {
            premarker.setDraggable(true);
        }
    }
      
    public MapModel getDraggableModel() {
        return draggableModel;
    }
      
    public void onMarkerDrag(MarkerDragEvent event) {
        marker = event.getMarker();
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Dragged", "Lat:" + marker.getLatlng().getLat() + ", Lng:" + marker.getLatlng().getLng()));
    }
}