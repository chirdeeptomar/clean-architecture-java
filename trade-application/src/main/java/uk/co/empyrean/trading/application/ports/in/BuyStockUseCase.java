package uk.co.empyrean.trading.application.ports.in;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Value;
import uk.co.empyrean.hexagon.SelfValidating;

import javax.validation.constraints.NotNull;
import java.util.Currency;
import java.util.UUID;

public interface BuyStockUseCase {

    boolean buyStock(BuyStockCommand command);

    @Value
    @Getter
    @EqualsAndHashCode(callSuper = true)
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
        private Float rate;

        public BuyStockCommand(Integer quantity, Currency currency, String stock, UUID buyer, UUID seller, Float rate) {
            this.quantity = quantity;
            this.currency = currency;
            this.stock = stock;
            this.buyer = buyer;
            this.seller = seller;
            this.rate = rate;
            this.validateSelf();
        }
    }
}
