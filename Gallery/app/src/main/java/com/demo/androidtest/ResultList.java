package com.demo.androidtest;

import java.io.Serializable;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultList implements Serializable, Parcelable
{

    @SerializedName("urls")
    @Expose
    private Urls urls;
    public final static Creator<ResultList> CREATOR = new Creator<ResultList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResultList createFromParcel(android.os.Parcel in) {
            return new ResultList(in);
        }

        public ResultList[] newArray(int size) {
            return (new ResultList[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5584457947360426343L;

    protected ResultList(android.os.Parcel in) {
        this.urls = ((Urls) in.readValue((Urls.class.getClassLoader())));
    }

    public ResultList() {
    }

    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(urls);
    }

    public int describeContents() {
        return 0;
    }

}
