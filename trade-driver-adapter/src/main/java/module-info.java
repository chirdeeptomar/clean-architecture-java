open module uk.co.empyrean.trading.adapters.driver.rest {
    requires static lombok;

    requires java.validation;
    requires spring.context;
    requires spring.beans;
    requires spring.core;
    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires uk.co.empyrean.trading.core;
}