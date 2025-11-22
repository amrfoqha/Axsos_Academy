package com.example.world1.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "languages", schema = "world", catalog = "")
public class Language {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "country_code", nullable = false, length = 3)
    private String countryCode;
    @Basic
    @Column(name = "language", nullable = false, length = 30)
    private String language;
    @Basic
    @Column(name = "is_official", nullable = false)
    private Object isOfficial;
    @Basic
    @Column(name = "percentage", nullable = false, precision = 1)
    private double percentage;
    @Basic
    @Column(name = "country_id", nullable = false, insertable = false, updatable = false)
    private int country;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private Country countries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Object getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(Object isOfficial) {
        this.isOfficial = isOfficial;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language that = (Language) o;
        return id == that.id && Double.compare(percentage, that.percentage) == 0 && country == that.country && Objects.equals(countryCode, that.countryCode) && Objects.equals(language, that.language) && Objects.equals(isOfficial, that.isOfficial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryCode, language, isOfficial, percentage, country);
    }

    public Country getCountries() {
        return countries;
    }

    public void setCountries(Country countries) {
        this.countries = countries;
    }
}
