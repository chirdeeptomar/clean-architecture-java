package uk.co.empyrean.trading.core.domain;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

public class Trade {
    private final UUID id;
    private final LocalDateTime timestamp;
    private final Quantity quantity;
    private final Currency currency;
    private final Stock stock;
    private final Buyer buyer;
    private final Seller seller;
    private final Rate rate;

    public Trade(LocalDateTime now, Quantity quantity, Currency currency, Stock stock, Buyer buyer, Seller seller, Rate rate) {
        this.id = null;
        this.timestamp = now;
        this.quantity = quantity;
        this.currency = currency;
        this.stock = stock;
        this.buyer = buyer;
        this.seller = seller;
        this.rate = rate;
    }

    public static class Stock {
        private final String name;

        public Stock(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Rate {
        private final double rate;

        public Rate(double rate) {
            this.rate = rate;
        }

        public double getRate() {
            return rate;
        }
    }

    public static class Quantity {
        private final Integer amount;

        public Quantity(Integer amount) {
            this.amount = amount;
        }

        public Integer getAmount() {
            return amount;
        }
    }

    public static class Party {
        private UUID id;
        private String name;

        public Party(UUID id, String name) {
            this.id = id;
            this.name = name;
        }

        public UUID getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Buyer extends Party {
        public Buyer(UUID id, String name) {
            super(id, name);
        }
    }

    public static class Seller extends Party {
        public Seller(UUID id, String name) {
            super(id, name);
        }
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Stock getStock() {
        return stock;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public Rate getRate() {
        return rate;
    }

}