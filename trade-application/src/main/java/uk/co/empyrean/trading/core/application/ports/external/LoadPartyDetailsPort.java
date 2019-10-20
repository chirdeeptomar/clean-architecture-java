package uk.co.empyrean.trading.core.application.ports.external;

import uk.co.empyrean.trading.core.domain.Trade;

import java.util.Optional;
import java.util.UUID;

public interface LoadPartyDetailsPort {
    Optional<Trade.Party> getPartyById(UUID id);
}
