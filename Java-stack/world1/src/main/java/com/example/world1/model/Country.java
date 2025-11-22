package com.example.world1.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "countries", schema = "world", catalog = "")
public class Country {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "code", nullable = false, length = 3)
    private String code;
    @Basic
    @Column(name = "name", nullable = false, length = 52)
    private String name;
    @Basic
    @Column(name = "continent", nullable = false)
    private Object continent;
    @Basic
    @Column(name = "region", nullable = false, length = 26)
    private String region;
    @Basic
    @Column(name = "surface_area", nullable = false, precision = 2)
    private double surfaceArea;
    @Basic
    @Column(name = "indep_year", nullable = true)
    private Short indepYear;
    @Basic
    @Column(name = "population", nullable = false)
    private int population;
    @Basic
    @Column(name = "life_expectancy", nullable = true, precision = 1)
    private Double lifeExpectancy;
    @Basic
    @Column(name = "gnp", nullable = true, precision = 2)
    private Double gnp;
    @Basic
    @Column(name = "gnp_old", nullable = true, precision = 2)
    private Double gnpOld;
    @Basic
    @Column(name = "local_name", nullable = false, length = 45)
    private String localName;
    @Basic
    @Column(name = "government_form", nullable = false, length = 45)
    private String governmentForm;
    @Basic
    @Column(name = "head_of_state", nullable = true, length = 60)
    private String headOfState;
    @Basic
    @Column(name = "capital", nullable = true)
    private Integer capital;
    @Basic
    @Column(name = "code2", nullable = false, length = 2)
    private String code2;
    @OneToMany(mappedBy = "countries")
    private Collection<City> cities;
    @OneToMany(mappedBy = "countries")
    private Collection<Language> languages;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getContinent() {
        return continent;
    }

    public void setContinent(Object continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Double getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public Double getGnp() {
        return gnp;
    }

    public void setGnp(Double gnp) {
        this.gnp = gnp;
    }

    public Double getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Double gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country that = (Country) o;
        return id == that.id && Double.compare(surfaceArea, that.surfaceArea) == 0 && population == that.population && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(continent, that.continent) && Objects.equals(region, that.region) && Objects.equals(indepYear, that.indepYear) && Objects.equals(lifeExpectancy, that.lifeExpectancy) && Objects.equals(gnp, that.gnp) && Objects.equals(gnpOld, that.gnpOld) && Objects.equals(localName, that.localName) && Objects.equals(governmentForm, that.governmentForm) && Objects.equals(headOfState, that.headOfState) && Objects.equals(capital, that.capital) && Objects.equals(code2, that.code2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, continent, region, surfaceArea, indepYear, population, lifeExpectancy, gnp, gnpOld, localName, governmentForm, headOfState, capital, code2);
    }

    public Collection<City> getCities() {
        return cities;
    }

    public void setCities(Collection<City> cities) {
        this.cities = cities;
    }

    public Collection<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Collection<Language> languages) {
        this.languages = languages;
    }
}
