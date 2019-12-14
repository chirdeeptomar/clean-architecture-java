open module uk.co.empyrean.trading.driven {
    exports uk.co.empyrean.trading.driven.persistence.repository;
    exports uk.co.empyrean.trading.driven.persistence.model;
    exports uk.co.empyrean.trading.driven.persistence.adapter;
    exports uk.co.empyrean.trading.driven.config;

    requires javax.inject;
    requires java.persistence;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.boot.starter.aop;
    requires spring.boot.starter.data.jpa;
    requires uk.co.empyrean.trading.core;
    requires spring.boot.autoconfigure;
}