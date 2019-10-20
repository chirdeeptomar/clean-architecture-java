package uk.co.empyrean.trading.driver.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.empyrean.trading.core.application.ports.internal.BuyStockUseCase;
import uk.co.empyrean.trading.driver.api.requests.BuyStockRequest;

import java.util.Currency;

@RestController
@RequestMapping(value = "/v1/api/trades", consumes = "application/json")
public class TradeController {

    private final BuyStockUseCase buyStockUseCase;

    public TradeController(BuyStockUseCase buyStockUseCase) {
        this.buyStockUseCase = buyStockUseCase;
    }

    @PostMapping
    public boolean buyStock(BuyStockRequest request) {
        BuyStockUseCase.BuyStockCommand command = new BuyStockUseCase.BuyStockCommand(
                request.getQuantity(),
                Currency.getInstance(request.getCurrencyCode()),
                request.getStock(),
                request.getBuyer(),
                request.getSeller(),
                request.getRate()
        );
        return buyStockUseCase.buyStock(command);
    }
}
