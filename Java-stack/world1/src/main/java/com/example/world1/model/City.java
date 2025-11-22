package com.example.world1.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cities", schema = "world", catalog = "")
public class City {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 35)
    private String name;
    @Basic
    @Column(name = "country_code", nullable = false, length = 3)
    private String countryCode;
    @Basic
    @Column(name = "district", nullable = false, length = 20)
    private String district;
    @Basic
    @Column(name = "population", nullable = false)
    private int population;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getCountryId() {
        return country;
    }

    public void setCountryId(int country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City that = (City) o;
        return id == that.id && population == that.population && country == that.country && Objects.equals(name, that.name) && Objects.equals(countryCode, that.countryCode) && Objects.equals(district, that.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryCode, district, population, country);
    }

    public Country getCountries() {
        return countries;
    }

    public void setCountries(Country countries) {
        this.countries = countries;
    }
}
