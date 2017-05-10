package com.edernilson.beans;

import com.edernilson.componentes.model.leaflet.DefaultMapModel;
import com.edernilson.componentes.model.leaflet.LatLng;
import com.edernilson.componentes.model.leaflet.LatLngBounds;
import com.edernilson.componentes.model.leaflet.MapModel;
import com.edernilson.componentes.model.leaflet.Rectangle;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eder.nilson
 */
@ManagedBean
public class RectanglesView implements Serializable {
 
    private MapModel rectangleModel;
 
    @PostConstruct
    public void init() {
        rectangleModel = new DefaultMapModel();
 
        LatLng ne = new LatLng(36.879466, 30.667648);
        LatLng sw = new LatLng(36.885233, 30.702323);
 
        //Rectangle
        Rectangle rect = new Rectangle(new LatLngBounds(sw, ne));
        rect.setStrokeColor("#d93c3c");
        rect.setFillColor("#d93c3c");
        rect.setFillOpacity(0.5);
        rectangleModel.addOverlay(rect);
    }
 
    public MapModel getRectangleModel() {
        return rectangleModel;
    }

}
