package com.eshop.someData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raks on 20.09.16.
 */
public class basketData {
    Map <String, String> data = new HashMap<>();

    public Map basketDataRet(){
        for(int i=0; i< 10; i++){
            data.put("jpg", "JPG");
            data.put("Some title", "Bla-bla-bla-bla");
        }
        return data;
    }
}
