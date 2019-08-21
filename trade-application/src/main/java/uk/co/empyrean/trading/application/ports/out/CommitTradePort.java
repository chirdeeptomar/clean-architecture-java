package uk.co.empyrean.trading.application.ports.out;

import uk.co.empyrean.trading.domain.Trade;

public interface CommitTradePort {
    void commitTrade(Trade trade);
}
