package uk.co.empyrean.trading.core.application.ports.internal;

import uk.co.empyrean.hexagon.SelfValidating;

import javax.validation.constraints.NotNull;
import java.util.Currency;
import java.util.UUID;

public interface BuyStockUseCase {

    boolean buyStock(BuyStockCommand command);

    class BuyStockCommand extends SelfValidating<BuyStockCommand> {

        @NotNull
        private Integer quantity;

        @NotNull
        private Currency currency;

        @NotNull
        private String stock;

        @NotNull
        private UUID buyer;

        @NotNull
        private UUID seller;

        @NotNull
        private Double rate;

        public BuyStockCommand(Integer quantity, Currency currency, String stock, UUID buyer, UUID seller, Double rate) {
            this.quantity = quantity;
            this.currency = currency;
            this.stock = stock;
            this.buyer = buyer;
            this.seller = seller;
            this.rate = rate;
            this.validateSelf();
        }

        public Integer getQuantity() {
            return quantity;
        }

        public Currency getCurrency() {
            return currency;
        }

        public String getStock() {
            return stock;
        }

        public UUID getBuyer() {
            return buyer;
        }

        public UUID getSeller() {
            return seller;
        }

        public Double getRate() {
            return rate;
        }
    }
}
