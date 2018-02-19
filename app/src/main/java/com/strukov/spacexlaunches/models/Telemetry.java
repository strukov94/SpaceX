package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthew on 17.02.2018.
 */

public class Telemetry {
    @SerializedName("flight_club")
    private String flightClub;

    public String getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(String flightClub) {
        this.flightClub = flightClub;
    }
}
