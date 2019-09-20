package com.rdhd.app.models;

public class ProviderService {
    private String name;
    private String id;
    private String price;
    private String period;
    private String pricepp;
    private String col;

    public ProviderService(String name, String id, String price, String period, String pricepp, String col) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.period = period;
        this.pricepp = pricepp;
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPricepp() {
        return pricepp;
    }

    public void setPricepp(String pricepp) {
        this.pricepp = pricepp;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }
}
