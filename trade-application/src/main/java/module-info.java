open module uk.co.empyrean.trading.core {
    exports uk.co.empyrean.trading.core.domain;
    exports uk.co.empyrean.trading.core.application.ports.external;
    exports uk.co.empyrean.trading.core.application.ports.internal;

    requires javax.inject;
    requires java.validation;
    requires spring.context;
    requires uk.co.empyrean.hexagon;
}