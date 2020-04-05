package com.jordanec.rabbitmq_sample_covid_19.sender.service;

import com.jordanec.rabbitmq_sample_covid_19.model.Country;
import com.jordanec.rabbitmq_sample_covid_19.model.Update;
import com.jordanec.rabbitmq_sample_covid_19.sender.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Service
public class CountryService
{
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    UpdateService updateService;

    public Country getByName(String name)
    {
        return countryRepository.getByName(name);
    }

    private void setCountryData(Country country, Update update)
    {
        country.setCases(update.getCases());
        country.setDeaths(update.getDeaths());
        country.setRecovered(update.getRecovered());
        country.setActives(country.getCases() - (country.getRecovered() + country.getDeaths()));
        country.setLastUpdate(update.getLastUpdate());
    }

    @Transactional(value = REQUIRED)
    public void save(Country country)
    {
        countryRepository.save(country);
    }

    @Transactional(value = REQUIRED)
    public void validateAndSave(Update update) throws Exception
    {
        Country country = getByName(update.getCountryName());
        if (country == null)
        {
            country = new Country();
            country.setName(update.getCountryName());
            country.setContinent(update.getContinent());
            update.setUpdateOfTheDay(1);
        }
        else
        {
            updateService.assignNextUpdateOfTheDay(update);
        }
        setCountryData(country, update);
        save(country);
        update.setCountry(country);
    }
}
