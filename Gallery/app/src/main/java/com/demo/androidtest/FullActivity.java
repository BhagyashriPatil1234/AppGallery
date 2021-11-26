package com.demo.androidtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demo.androidtest.databinding.ActivityFullBinding;

public class FullActivity extends AppCompatActivity {

    private ActivityFullBinding binding;
    private String fullURL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            binding = DataBindingUtil.setContentView(this,R.layout.activity_full);
            Intent intent = getIntent();
            fullURL = intent.getStringExtra("FullURL");

            Glide.with(this)
                    .load(Uri.parse(fullURL.replace("\\", "")))
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.fullSizeImageId);

        }catch (Exception e){
            e.getMessage();
        }
    }
}