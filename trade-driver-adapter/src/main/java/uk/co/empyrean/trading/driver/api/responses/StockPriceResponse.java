package uk.co.empyrean.trading.driver.api.responses;

public class StockPriceResponse {
    private final String stock;
    private final float price;

    public StockPriceResponse(String stock, float price) {
        this.stock = stock;
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public float getPrice() {
        return price;
    }
}
