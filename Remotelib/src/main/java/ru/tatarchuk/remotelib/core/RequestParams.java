package ru.tatarchuk.remotelib.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tatarchukilya@gmail.com
 */
public abstract class RequestParams {

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        onMapCreate(map);
        return map;
    }

    public abstract void onMapCreate(Map<String, String> map);
}
