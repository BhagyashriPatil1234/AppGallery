package com.demo.androidtest;

import java.io.Serializable;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Urls implements Serializable, Parcelable
{

    @SerializedName("raw")
    @Expose
    private String raw;
    @SerializedName("full")
    @Expose
    private String full;
    @SerializedName("regular")
    @Expose
    private String regular;
    @SerializedName("small")
    @Expose
    private String small;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    public final static Creator<Urls> CREATOR = new Creator<Urls>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Urls createFromParcel(android.os.Parcel in) {
            return new Urls(in);
        }

        public Urls[] newArray(int size) {
            return (new Urls[size]);
        }

    }
            ;
    private final static long serialVersionUID = -419763085153709978L;

    protected Urls(android.os.Parcel in) {
        this.raw = ((String) in.readValue((String.class.getClassLoader())));
        this.full = ((String) in.readValue((String.class.getClassLoader())));
        this.regular = ((String) in.readValue((String.class.getClassLoader())));
        this.small = ((String) in.readValue((String.class.getClassLoader())));
        this.thumb = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Urls() {
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(raw);
        dest.writeValue(full);
        dest.writeValue(regular);
        dest.writeValue(small);
        dest.writeValue(thumb);
    }

    public int describeContents() {
        return 0;
    }

}
