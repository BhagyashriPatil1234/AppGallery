package com.demo.androidtest;

import org.json.JSONArray;
import org.json.JSONObject;

public interface ResponseHandleListener {
    void onGetAPIResponse(JSONObject response, String TAG);
}
