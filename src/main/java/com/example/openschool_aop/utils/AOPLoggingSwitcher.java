package com.example.openschool_aop.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "application.properties")
@Getter
public class AOPLoggingSwitcher {

    @Value("${aop_logger_enabled}")
    Boolean isEnabled;

    public String switchProperty() {
        this.isEnabled = !isEnabled;
        return isEnabled.toString();
    }
}
