package com.example.airplanelist;

import java.io.Serializable;
import java.net.MalformedURLException;

public class Airline  implements Serializable {

    public Airline(String name, String callSign,
                   String icon, String originCountry, String homeBaseAirport, String url, String ranking,
                   String foundDate, String alliance, String wikiSubject) throws MalformedURLException {
        this.name = name;
        this.callSign = callSign;
        this.icon = icon;
        this.originCountry = originCountry;
        this.homeBaseAirport = homeBaseAirport;
        this.url = url;
        this.ranking = ranking;
        this.foundDate = foundDate;
        this.alliance = alliance;
        this.wikiSubject = wikiSubject;

    }


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

    public String getFoundDate() {
        return foundDate;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

//    public void setSomeInfo() throws MalformedURLException {
//        WikiParser wikiParser = new WikiParser();
//        this.someInfo = wikiParser.getInfo(this.wikiSubject);
//    }

    public String getSomeInfo() {
        return someInfo;
    }

    private String name, originCountry, homeBaseAirport, icon, url, callSign, ranking, foundDate,
            alliance, someInfo, wikiSubject;

    public String getWikiSubject() {
        return wikiSubject;
    }

    public void setWikiSubject(String wikiSubject) {
        this.wikiSubject = wikiSubject;
    }


}
