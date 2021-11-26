package com.demo.androidtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{

    private Context context;
    private ArrayList<ResultList> resultListMain;
    private OnImageClickListener listener;

    public ImageAdapter(Context context, ArrayList<ResultList> resultList) {
        this.context = context;
        resultListMain= resultList;
        listener = (OnImageClickListener) context;
    }

    @NonNull
    @Override
    public ImageAdapter.ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        try {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //View convertView = layoutInflater.inflate(R.layout. refund_list_adapter_row, parent, false);
            View convertView = layoutInflater.inflate(R.layout.image_item, parent, false);
            ImageViewHolder mPredictionHolder = new ImageViewHolder(convertView);
            return mPredictionHolder;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ImageViewHolder imageViewHolder, @SuppressLint("RecyclerView") int i) {
        try{
                Glide.with(context)
                        .load(Uri.parse(resultListMain.get(i).getUrls().getThumb().replace("\\", "")))
                        .thumbnail(0.5f)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(imageViewHolder.imageView);


                imageViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onImageClicked(i);
                    }
                });


        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public int getItemCount() {
        return resultListMain.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
