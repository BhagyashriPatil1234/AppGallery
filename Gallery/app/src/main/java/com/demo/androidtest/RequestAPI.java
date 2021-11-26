package com.demo.androidtest;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class RequestAPI {

    private Context context;
    private RequestQueue mRequestQueue;
    private String URL;
    private ResponseHandleListener listener;


    public RequestAPI(Context c) {
        this.context = c;
        this.mRequestQueue = Volley.newRequestQueue(c);
        listener = (ResponseHandleListener) c;
    }

    public void CallAPI(String url, final String TAG, final Map<String, String> _header, final JSONObject jsonObject) {
        try {

            URL = url;
            Log.e("DATA", url);

        /*JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray responseArray) {

                try {
                    if(responseArray!=null)
                    {
                        Log.e("DATA",responseArray.toString());
                        //listener.onGetAPIResponse(responseArray,TAG);
                    }
                } catch (Exception ex) {
                    ex.getMessage();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                try{
                    mRequestQueue.cancelAll("REG");
                    //listener.onGetAPIResponse("ERROR",TAG);
                }catch (Exception e){
                    e.getMessage();
                }

            }
        });*/

            Log.e("DATA", url);
            JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response != null)
                                    Log.e("DATA", response.toString());
                                {
                                    listener.onGetAPIResponse(response, TAG);
                                }
                            } catch (Exception ex) {
                                ex.getMessage();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    try {
                        mRequestQueue.cancelAll("REG");
                        //listener.onGetAPIResponse("ERROR",TAG);

                    } catch (Exception e) {
                        e.getMessage();
                    }

                }
            });
            RETRYRequest(getRequest);
            mRequestQueue.add(getRequest);


        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void RETRYRequest(JsonObjectRequest getRequest)
    {
        try {
            getRequest.setRetryPolicy(new DefaultRetryPolicy(60 * 1000, 0,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        } catch (Exception e) {
            e.getMessage();
        }
    }
    private void RETRYRequest(JsonArrayRequest getRequest)
    {
        try {
            getRequest.setRetryPolicy(new DefaultRetryPolicy(60 * 1000, 0,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

