package com.demo.androidtest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel implements Serializable, Parcelable {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private ArrayList<ResultList> results = null;
    public final static Creator<DataModel> CREATOR = new Creator<DataModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DataModel createFromParcel(android.os.Parcel in) {
            return new DataModel(in);
        }

        public DataModel[] newArray(int size) {
            return (new DataModel[size]);
        }

    };
    private final static long serialVersionUID = 6549045154119453344L;

    protected DataModel(android.os.Parcel in) {
        this.total = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (ResultList.class.getClassLoader()));
    }

    public DataModel() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<ResultList> getResults() {
        return results;
    }

    public void setResults(ArrayList<ResultList> results) {
        this.results = results;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(totalPages);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }

}
