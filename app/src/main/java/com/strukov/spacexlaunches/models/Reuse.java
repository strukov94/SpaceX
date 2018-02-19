package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthew on 17.02.2018.
 */

public class Reuse {
    @SerializedName("core")
    private Boolean core;
    @SerializedName("side_core1")
    private Boolean sideCore1;
    @SerializedName("side_core2")
    private Boolean sideCore2;
    @SerializedName("fairings")
    private Boolean fairings;
    @SerializedName("capsule")
    private Boolean capsule;

    public Boolean getCore() {
        return core;
    }

    public void setCore(Boolean core) {
        this.core = core;
    }

    public Boolean getSideCore1() {
        return sideCore1;
    }

    public void setSideCore1(Boolean sideCore1) {
        this.sideCore1 = sideCore1;
    }

    public Boolean getSideCore2() {
        return sideCore2;
    }

    public void setSideCore2(Boolean sideCore2) {
        this.sideCore2 = sideCore2;
    }

    public Boolean getFairings() {
        return fairings;
    }

    public void setFairings(Boolean fairings) {
        this.fairings = fairings;
    }

    public Boolean getCapsule() {
        return capsule;
    }

    public void setCapsule(Boolean capsule) {
        this.capsule = capsule;
    }
}
