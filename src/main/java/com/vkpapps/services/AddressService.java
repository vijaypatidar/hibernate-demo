package com.vkpapps.services;

import com.vkpapps.dto.CityDto;
import com.vkpapps.dto.CountryDto;
import com.vkpapps.dto.StateDto;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Optional;

public interface AddressService extends InitializingBean {
    Optional<CityDto> findCityByName(String cityName);
    Optional<StateDto> findStateByCountryCode(String stateCode);
    Optional<CountryDto> findCountryByCountryCode(String countryCode);
    List<CityDto> findCities(String countryCode, String stateCode);

    List<CountryDto> findCountries();
}
