package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthew on 17.02.2018.
 */

public class Rocket {
    @SerializedName("rocket_id")
    private String rocketId;
    @SerializedName("rocket_name")
    private String rocketName;
    @SerializedName("rocket_type")
    private String rocketType;
    @SerializedName("first_stage")
    private FirstStage firstStage;
    @SerializedName("second_stage")
    private SecondStage secondStage;

    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public SecondStage getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.secondStage = secondStage;
    }
}
