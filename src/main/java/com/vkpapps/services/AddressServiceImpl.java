package com.vkpapps.services;

import com.vkpapps.dto.CityDto;
import com.vkpapps.dto.CountryDto;
import com.vkpapps.dto.StateDto;
import com.vkpapps.entities.City;
import com.vkpapps.entities.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AddressServiceImpl implements AddressService {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<CityDto> findCityByName(String cityName) {
        return Optional.empty();
    }

    @Override
    public Optional<StateDto> findStateByCountryCode(String stateCode) {
        return Optional.empty();
    }

    @Override
    public Optional<CountryDto> findCountryByCountryCode(String countryCode) {
        return Optional.empty();
    }

    @Override
    public List<CityDto> findCities(String countryCode, String stateCode) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("select c from City c", City.class)
                    .list()
                    .stream()
                    .map(City::toDto).collect(Collectors.toList());
        }
    }

    @Override
    public List<CountryDto> findCountries() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("select c from Country c", Country.class)
                    .list()
                    .stream()
                    .map(Country::toDto).collect(Collectors.toList());
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // Used to init local variable after spring created the bean of this class
    }
}
