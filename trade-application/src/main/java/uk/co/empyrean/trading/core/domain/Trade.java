package uk.co.empyrean.trading.core.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Trade {
    private final UUID id = null;
    private final LocalDateTime timestamp;
    private final Quantity quantity;
    private final Currency currency;
    private final Stock stock;
    private final Buyer buyer;
    private final Seller seller;
    private final Rate rate;

    @Getter
    @RequiredArgsConstructor
    public static class Stock {
        private final String name;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Rate {
        private final double rate;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Quantity {
        private final Integer amount;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Party {
        private final UUID id;
        private final String name;
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
}