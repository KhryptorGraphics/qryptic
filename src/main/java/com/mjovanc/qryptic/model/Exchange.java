package com.mjovanc.qryptic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

/**
 * Represents an Exchange entity.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0
 */
@Entity
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @JsonProperty("website_url")
    @Column(name="website_url")
    private String websiteURL;

    @ManyToMany(mappedBy="cryptoCurrencyExchanges")
    List<CryptoCurrency> cryptocurrencies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public List<CryptoCurrency> getCryptocurrencies() {
        return cryptocurrencies;
    }

    public void setCryptocurrencies(List<CryptoCurrency> cryptocurrencies) {
        this.cryptocurrencies = cryptocurrencies;
    }
}