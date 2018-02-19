package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthew on 17.02.2018.
 */

public class Core {
    @SerializedName("core_serial")
    private String coreSerial;
    @SerializedName("flight")
    private Integer flight;
    @SerializedName("block")
    private Integer block;
    @SerializedName("reused")
    private Boolean reused;
    @SerializedName("land_success")
    private Boolean landSuccess;
    @SerializedName("landing_type")
    private String landingType;
    @SerializedName("landing_vehicle")
    private Object landingVehicle;

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(Boolean landSuccess) {
        this.landSuccess = landSuccess;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public Object getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(Object landingVehicle) {
        this.landingVehicle = landingVehicle;
    }
}
