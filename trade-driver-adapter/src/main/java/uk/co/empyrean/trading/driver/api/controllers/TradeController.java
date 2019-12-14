package uk.co.empyrean.trading.driver.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Boolean> buyStock(@RequestBody BuyStockRequest request) {
        BuyStockUseCase.BuyStockCommand command = new BuyStockUseCase.BuyStockCommand(
                request.getQuantity(),
                Currency.getInstance(request.getCurrencyCode()),
                request.getStock(),
                request.getBuyer(),
                request.getSeller(),
                request.getRate()
        );
        return ResponseEntity.ok(buyStockUseCase.buyStock(command));
    }
}
