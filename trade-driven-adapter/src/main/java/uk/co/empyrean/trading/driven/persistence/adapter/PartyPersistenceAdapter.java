package uk.co.empyrean.trading.driven.persistence.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import uk.co.empyrean.trading.core.application.ports.external.LoadPartyDetailsPort;
import uk.co.empyrean.trading.core.domain.Trade;
import uk.co.empyrean.trading.driven.persistence.model.PartyJpaEntity;
import uk.co.empyrean.trading.driven.persistence.repository.PartyRepository;

import java.util.Optional;
import java.util.UUID;

@Component
class PartyPersistenceAdapter implements LoadPartyDetailsPort {

    private final PartyRepository partyRepository;

    PartyPersistenceAdapter(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public Optional<Trade.Party> getPartyById(UUID id) {
        Optional<PartyJpaEntity> party = partyRepository.findById(id);
        return party.map(p -> new Trade.Party(p.getId(), p.getName()));
    }

    @Bean
    LoadPartyDetailsPort loadPartyDetailsPort(PartyRepository partyRepository) {
        return new PartyPersistenceAdapter(partyRepository);
    }
}
