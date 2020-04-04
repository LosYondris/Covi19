package com.cornelio.losyondris.covi19;

public class Poo {
//    private String countryInfo;
//    private String _id;
//    private String iso2;
//    private String iso3;
//    private String lat;
//    private String longx;
    private String country; //pais
    private String flag; //vandera
    private String cases; //total de casos
    private String todayCases; //casos por dias
    private String deaths; //total muerto
    private String todayDeaths; // muerto por dia
    private String recovered; //recuperados
//    private String active;
//    private String critical;
//    private String casesPerOneMillion;
//    private String deathsPerOneMillion;
//    private String updated;


    public Poo(String country, String flag, String cases, String todayCases, String deaths, String todayDeaths, String recovered) {
        this.country = country;
        this.flag = flag;
        this.cases = cases;
        this.todayCases = todayCases;
        this.deaths = deaths;
        this.todayDeaths = todayDeaths;
        this.recovered = recovered;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(String todayCases) {
        this.todayCases = todayCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }
}