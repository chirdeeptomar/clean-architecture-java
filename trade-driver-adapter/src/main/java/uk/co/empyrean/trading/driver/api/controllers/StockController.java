package uk.co.empyrean.trading.driver.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.empyrean.trading.core.application.ports.internal.GetStockPriceUseCase;
import uk.co.empyrean.trading.driver.api.responses.StockPriceResponse;

import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/api/stocks")
public class StockController {
    private final GetStockPriceUseCase getStockPriceUseCase;

    public StockController(GetStockPriceUseCase getStockPriceUseCase) {
        this.getStockPriceUseCase = getStockPriceUseCase;
    }

    @GetMapping("/{stock}")
    public ResponseEntity<StockPriceResponse> getStockPrice(@PathVariable String stock) {
        GetStockPriceUseCase.GetStockPriceCommand command = new GetStockPriceUseCase.GetStockPriceCommand(stock);
        Optional<Float> stockPrice = getStockPriceUseCase.getStockPrice(command);
        return stockPrice.map(val -> ResponseEntity.ok(new StockPriceResponse(stock, val)))
                .orElseGet(() -> ResponseEntity.ok(new StockPriceResponse(stock, 0.0f)));
    }
}
