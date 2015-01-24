package com.solizj.platformer.model;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;

    public Level(String mapPath){
        map = new TmxMapLoader().load(mapPath);
    }

    public MapLayer getMapLayer(String layerName){ // [38] Gt the layer found in the map
        return map.getLayers().get(layerName);
    }
    public MapObjects getLayerObjects(MapLayer mapLayer){// [38] Get objects found within the layer
        return mapLayer.getObjects();
    }
}
