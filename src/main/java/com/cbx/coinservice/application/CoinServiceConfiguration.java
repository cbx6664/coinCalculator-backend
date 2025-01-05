package com.cbx.coinservice.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

/**
 * ClassName: CoinServiceConfiguration
 * Package: com.cbx.coinservice
 * Description:
 *
 * @Author CBX
 * @Create 4/1/25 18:07
 * @Version 1.0
 */
public class CoinServiceConfiguration extends Configuration {
    @NotEmpty
    private String serviceName;

    @NotEmpty
    private String defaultCurrency;

    @JsonProperty
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty
    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    @JsonProperty
    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
}
