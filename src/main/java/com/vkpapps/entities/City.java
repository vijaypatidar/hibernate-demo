package com.vkpapps.entities;

import com.vkpapps.dto.CityDto;
import com.vkpapps.dto.EntityToDtoConverter;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City implements EntityToDtoConverter<CityDto> {
    @Id
    @Column(name = "city_id")
    private long id;
    @Column(name = "city_name")
    private String cityName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private State state;
    public State getState() {
        return state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    @Override
    public CityDto toDto() {
        return new CityDto(
                this.id,
                this.cityName
        );
    }
}
