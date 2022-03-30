package com.vkpapps.controllers;

import com.vkpapps.dto.CityDto;
import com.vkpapps.dto.CountryDto;
import com.vkpapps.events.CityLoadEvent;
import com.vkpapps.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/country")
    List<CountryDto> getCountryies() {
        return addressService.findCountries();
    }

    @GetMapping("/country/{countryCode}/state/{stateCode}")
    List<CityDto> getCityById(
            @PathVariable String countryCode,
            @PathVariable String stateCode
    ) {
        eventPublisher.publishEvent(new CityLoadEvent(this));
        return addressService.findCities(countryCode, stateCode);
    }


}
