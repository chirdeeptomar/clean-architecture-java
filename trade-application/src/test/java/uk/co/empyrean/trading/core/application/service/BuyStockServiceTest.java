package uk.co.empyrean.trading.core.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.empyrean.trading.core.application.ports.external.CommitTradePort;
import uk.co.empyrean.trading.core.application.ports.external.LoadPartyDetailsPort;
import uk.co.empyrean.trading.core.application.ports.internal.BuyStockUseCase;

import java.util.Currency;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class BuyStockServiceTest {

    BuyStockUseCase sut;

    CommitTradePort commitTradePort;
    LoadPartyDetailsPort loadPartyDetailsPort;

    @BeforeEach
    void setUp() {
        commitTradePort = mock(CommitTradePort.class);
        loadPartyDetailsPort = mock(LoadPartyDetailsPort.class);
        sut = new BuyStockService(commitTradePort, loadPartyDetailsPort);
    }

    @Test
    @DisplayName("Buy stock should fail when party not found")
    void buyStockShouldReturnFalse() {
        when(loadPartyDetailsPort.getPartyById(any(UUID.class))).thenReturn(Optional.empty());

        BuyStockUseCase.BuyStockCommand buyStockCommand = new BuyStockUseCase.BuyStockCommand(100,
                Currency.getInstance("USD"),
                "MSFT",
                UUID.randomUUID(),
                UUID.randomUUID(),
                10.d);

        boolean result = sut.buyStock(buyStockCommand);

        assertFalse(result);
    }
}