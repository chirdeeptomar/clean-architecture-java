open module uk.co.empyrean.trading.driven {
    exports uk.co.empyrean.trading.driven.config;
    exports uk.co.empyrean.trading.driven.persistence.adapter;

    requires static lombok;

    requires java.persistence;
    requires spring.context;
    requires spring.data.jpa;
    requires spring.data.commons;
    requires spring.boot.autoconfigure;
    requires spring.boot.starter.aop;
    requires spring.boot.starter.data.jpa;
    requires uk.co.empyrean.trading.core;

}