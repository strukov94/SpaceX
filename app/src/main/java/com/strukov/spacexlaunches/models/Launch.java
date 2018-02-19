package com.strukov.spacexlaunches.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Matthew on 17.02.2018.
 */

public class Launch {
    @SerializedName("flight_number")
    private Integer flightNumber;
    @SerializedName("launch_year")
    private String launchYear;
    @SerializedName("launch_date_unix")
    private Long launchDateUnix;
    @SerializedName("launch_date_utc")
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    private String launchDateLocal;
    @SerializedName("rocket")
    private Rocket rocket;
    @SerializedName("reuse")
    private Reuse reuse;
    @SerializedName("telemetry")
    private Telemetry telemetry;
    @SerializedName("launch_site")
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    private Boolean launchSuccess;
    @SerializedName("links")
    private Links links;
    @SerializedName("details")

    private String details;

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Long getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Long launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Reuse getReuse() {
        return reuse;
    }

    public void setReuse(Reuse reuse) {
        this.reuse = reuse;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
