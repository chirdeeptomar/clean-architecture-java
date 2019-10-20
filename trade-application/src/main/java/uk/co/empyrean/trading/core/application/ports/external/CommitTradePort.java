package uk.co.empyrean.trading.core.application.ports.external;

import uk.co.empyrean.trading.core.domain.Trade;

public interface CommitTradePort {
    void commitTrade(Trade trade);
}
