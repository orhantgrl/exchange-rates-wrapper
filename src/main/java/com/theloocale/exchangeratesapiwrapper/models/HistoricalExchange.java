package com.theloocale.exchangeratesapiwrapper.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.TreeMap;

/**
 * @author orhantgrl
 * created on 10/10/19.
 */
public class HistoricalExchange {
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("start_at")
    @Expose
    private String startAt;
    @SerializedName("end_at")
    @Expose
    private String endAt;
    @SerializedName("rates")
    @Expose
    private TreeMap<String, Rates> ratesMap;

    public HistoricalExchange(String base, String startAt, String endAt, TreeMap<String, Rates> ratesMap) {
        this.base = base;
        this.startAt = startAt;
        this.endAt = endAt;
        this.ratesMap = ratesMap;
    }

    public String getBase() {
        return base;
    }

    public String getStartAt() {
        return startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public TreeMap<String, Rates> getRatesMap() {
        return ratesMap;
    }
}
