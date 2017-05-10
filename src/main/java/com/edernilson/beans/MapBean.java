/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edernilson.beans;

import com.edernilson.componentes.model.leaflet.DefaultMapModel;
import com.edernilson.componentes.model.leaflet.LatLng;
import com.edernilson.componentes.model.leaflet.MapModel;
import com.edernilson.componentes.model.leaflet.Marker;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author eder.nilson
 */
@ManagedBean
@RequestScoped
public class MapBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private MapModel model = new DefaultMapModel();
    
    public MapBean(){
        model.addOverlay(new Marker(new LatLng(-3.5555, -38.6211), "M1"));
    }
    
    public MapModel getModel() {
        return this.model;
    }
    
}
