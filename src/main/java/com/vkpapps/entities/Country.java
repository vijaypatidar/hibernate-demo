package com.vkpapps.entities;

import com.vkpapps.dto.CountryDto;
import com.vkpapps.dto.EntityToDtoConverter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
public class Country implements EntityToDtoConverter<CountryDto> {
    @Id()
    @Column(name = "country_id")
    private long id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_code")
    private String countryCode;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<State> states = new HashSet<>();

    public long getId() {
        return id;
    }

    public Set<State> getStates() {
        return states;
    }

    public void setStates(Set<State> states) {
        this.states = states;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }

    @Override
    public CountryDto toDto() {
        return new CountryDto(
                this.id,
                this.countryName,
                this.countryCode
        );
    }
}
