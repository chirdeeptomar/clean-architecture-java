package uk.co.empyrean.trading.driver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"uk.co.empyrean.hexagon",
        "uk.co.empyrean.trading.core",
        "uk.co.empyrean.trading.driven",
        "uk.co.empyrean.trading.driver"})
@EntityScan(basePackages = {"uk.co.empyrean.trading.driven.persistence.model"})
public class TradingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradingApplication.class, args);
    }
}
