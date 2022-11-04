package com.example.airplanelist;

import java.io.Serializable;

public class Airline  implements Serializable {

    public Airline(String name, String callSign,
                   String icon, String originCountry, String homeBaseAirport, String url, String ranking) {
        this.name = name;
        this.callSign = callSign;
        this.icon = icon;
        this.originCountry = originCountry;
        this.homeBaseAirport = homeBaseAirport;
        this.url = url;
        this.ranking = ranking;
    }


    // have icon and logo attributes
    // dispaly icon only
    // when clicking on to the airline
    // dispaly details and its full logo

    private String name, originCountry, homeBaseAirport, icon, url, callSign, ranking;

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getHomeBaseAirport() {
        return homeBaseAirport;
    }

    public void setHomeBaseAirport(String homeBaseAirport) {
        this.homeBaseAirport = homeBaseAirport;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
