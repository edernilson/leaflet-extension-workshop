package com.edernilson.beans;

import com.edernilson.componentes.event.leaflet.OverlaySelectEvent;
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
public class MarkersView implements Serializable {

    private MapModel simpleModel;
    
    private Marker marker;

    @PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        //Shared coordinates
        LatLng coord1 = new LatLng(-3.734489, -38.5600023);
        LatLng coord2 = new LatLng(-3.7492242, -38.531305);

        simpleModel.addOverlay(new Marker(coord1, "Eder Nilson"));
        simpleModel.addOverlay(new Marker(coord2, "ViaSoluTI"));
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
    }
}
