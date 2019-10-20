package uk.co.empyrean.trading.driven.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"uk.co.empyrean.trading.driven.persistence.repository"})
class PersistenceConfig {
}
