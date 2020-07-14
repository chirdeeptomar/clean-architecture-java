package uk.co.empyrean.trading.driver.api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.empyrean.trading.core.application.ports.internal.GetStockPriceUseCase;
import uk.co.empyrean.trading.driver.api.responses.StockPriceResponse;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/api/stocks")
public class StockController {
    private final GetStockPriceUseCase getStockPriceUseCase;

    @GetMapping("/{stock}")
    public ResponseEntity<StockPriceResponse> getStockPrice(@PathVariable String stock) {
        GetStockPriceUseCase.GetStockPriceCommand command = new GetStockPriceUseCase.GetStockPriceCommand(stock);
        try {
            command.validate();
        } catch (ConstraintViolationException e) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Float> stockPrice = getStockPriceUseCase.getStockPrice(command);
        return stockPrice.map(val -> ResponseEntity.ok(new StockPriceResponse(stock, val)))
                .orElseGet(() -> ResponseEntity.ok(new StockPriceResponse(stock, 0.0f)));
    }
}
