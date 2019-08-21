package uk.co.empyrean.trading.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

@Data
@Builder
public class Trade {
    @Setter(AccessLevel.NONE)
    private UUID id;
    private LocalDateTime timestamp;
    private Quantity quantity;
    private Currency currency;
    private Stock stock;
    private Buyer buyer;
    private Seller seller;
    private Rate rate;

    @Getter
    @AllArgsConstructor
    public static class Stock {
        private String name;
    }

    @Getter
    @AllArgsConstructor
    public static class Rate {
        private Float rate;
    }

    @Getter
    @AllArgsConstructor
    public static class Quantity {
        private Integer amount;
    }

    @Getter
    @AllArgsConstructor
    public static class Party {
        private UUID id;
        private String name;
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
