package com.eshop.dataTO;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 19.09.2016.
 */

public class CollectData {
    protected Map <Integer, Integer> map= new HashMap<>();
    public Map addDataToMap (){
        for(int i =0; i<10; i++) {
            map.put(i, i+1);
        }
        return map;
    }
}
