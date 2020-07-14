package uk.co.empyrean.trading.core.application.ports.internal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import uk.co.empyrean.hexagon.SelfValidating;

import javax.validation.constraints.NotNull;
import java.util.Currency;
import java.util.UUID;

public interface BuyStockUseCase {

    boolean buyStock(BuyStockCommand command);

    @Getter
    @RequiredArgsConstructor
    class BuyStockCommand extends SelfValidating<BuyStockCommand> {

        @NotNull
        private final Integer quantity;

        @NotNull
        private final Currency currency;

        @NotNull
        private final String stock;

        @NotNull
        private final UUID buyer;

        @NotNull
        private final UUID seller;

        @NotNull
        private final Double rate;

        @Override
        public void validate() {
            this.validateSelf(this);
        }
    }
}
