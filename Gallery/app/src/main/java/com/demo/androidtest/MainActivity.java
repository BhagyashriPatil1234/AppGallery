package com.demo.androidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import com.demo.androidtest.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ResponseHandleListener,OnImageClickListener {

    private final Calendar myCalendar = Calendar.getInstance();
    private ActivityMainBinding binding;
    private DataModel dataModel;
    private ImageAdapter imageAdapter;
    private static final String API_TAG = "IMAGEAPI";
    private static final String API_URL = "https://api.unsplash.com/search/photos?query=rocket&per_page=40&client_id=3LG8LwNcmXYZQCplMqCw93lAlSu52v2QecSbAe-xWj8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {

            binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
            callImageListAPI();

        } catch (Exception e) {
            e.getMessage();
        }
    }

    private void bindAdapter(DataModel dataModel) {
        try{
            binding.imagesListViewId.setLayoutManager(new GridLayoutManager(this, 3));
            binding.imagesListViewId.setHasFixedSize(true); // Helps improve performance

            imageAdapter = new ImageAdapter(MainActivity.this,dataModel.getResults());
            binding.imagesListViewId.setAdapter(imageAdapter);


            /*binding.imagesListViewId.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    return false;
                }

                @Override
                public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    try{
                        Intent intent = new Intent(MainActivity.this, FullSize_Activity.class);
                        intent.putParcelableArrayListExtra("data", dataModel.getResults());
                        intent.putExtra("pos", position);
                        startActivity(intent);
                    }catch(Exception ex){
                        ex.getMessage();
                    }
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }*/

        }catch(Exception e){
            e.getMessage();
        }
    }

    private void callImageListAPI() {
        try{
            JSONObject jsonObject = new JSONObject();
            Map<String, String> headers = new HashMap<String, String>();
            new RequestAPI(MainActivity.this).CallAPI(API_URL,API_TAG,headers,jsonObject);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public void onGetAPIResponse(JSONObject response, String TAG) {
        try{
            switch (TAG){
                case API_TAG: parseImagesListResponse(response);
                    break;
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    private void parseImagesListResponse(JSONObject response) {
        try{

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("M/d/yy hh:mm a");
            Gson gson = gsonBuilder.create();
            dataModel = new DataModel();

            if (response != null) {
                try {
                    dataModel = gson.fromJson(response.toString(), DataModel.class);
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            if(dataModel!=null){
                bindAdapter(dataModel);
            }
            }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void onImageClicked(int position) {
        try{
            Intent intent = new Intent(MainActivity.this, FullActivity.class);
            intent.putExtra("FullURL", dataModel.getResults().get(position).getUrls().getFull());
            //intent.putExtra("pos", position);
            startActivity(intent);
        }catch (Exception e){
            e.getMessage();
        }
    }
}
