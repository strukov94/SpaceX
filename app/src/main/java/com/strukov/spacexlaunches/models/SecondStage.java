package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Matthew on 17.02.2018.
 */

public class SecondStage {
    @SerializedName("payloads")
    private List<Payload> payloads = null;

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }
}
