package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Matthew on 17.02.2018.
 */

public class FirstStage {
    @SerializedName("cores")
    private List<Core> cores = null;

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }
}
