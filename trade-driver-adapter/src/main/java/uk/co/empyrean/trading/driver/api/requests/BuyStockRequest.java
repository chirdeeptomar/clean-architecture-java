package uk.co.empyrean.trading.driver.api.requests;

import java.util.UUID;

public class BuyStockRequest {
    private Integer quantity;
    private String currencyCode;
    private String stock;
    private UUID buyer;
    private UUID seller;
    private double rate;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public UUID getBuyer() {
        return buyer;
    }

    public void setBuyer(UUID buyer) {
        this.buyer = buyer;
    }

    public UUID getSeller() {
        return seller;
    }

    public void setSeller(UUID seller) {
        this.seller = seller;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}