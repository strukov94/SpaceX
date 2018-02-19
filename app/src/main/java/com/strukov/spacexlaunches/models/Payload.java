package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Matthew on 17.02.2018.
 */

public class Payload {
    @SerializedName("payload_id")
    private String payloadId;
    @SerializedName("reused")
    private Boolean reused;
    @SerializedName("customers")
    private List<String> customers = null;
    @SerializedName("payload_type")
    private String payloadType;
    @SerializedName("payload_mass_kg")
    private Integer payloadMassKg;
    @SerializedName("payload_mass_lbs")
    private Double payloadMassLbs;
    @SerializedName("orbit")
    private String orbit;
    @SerializedName("cap_serial")
    private String capSerial;
    @SerializedName("mass_returned_kg")
    private Double massReturnedKg;
    @SerializedName("mass_returned_lbs")
    private Integer massReturnedLbs;
    @SerializedName("flight_time_sec")
    private Integer flightTimeSec;
    @SerializedName("cargo_manifest")
    private String cargoManifest;

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public Integer getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(Integer payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public Double getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(Double payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public String getCapSerial() {
        return capSerial;
    }

    public void setCapSerial(String capSerial) {
        this.capSerial = capSerial;
    }

    public Double getMassReturnedKg() {
        return massReturnedKg;
    }

    public void setMassReturnedKg(Double massReturnedKg) {
        this.massReturnedKg = massReturnedKg;
    }

    public Integer getMassReturnedLbs() {
        return massReturnedLbs;
    }

    public void setMassReturnedLbs(Integer massReturnedLbs) {
        this.massReturnedLbs = massReturnedLbs;
    }

    public Integer getFlightTimeSec() {
        return flightTimeSec;
    }

    public void setFlightTimeSec(Integer flightTimeSec) {
        this.flightTimeSec = flightTimeSec;
    }

    public String getCargoManifest() {
        return cargoManifest;
    }

    public void setCargoManifest(String cargoManifest) {
        this.cargoManifest = cargoManifest;
    }
}
