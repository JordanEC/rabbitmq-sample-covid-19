package com.jordanec.rabbitmq_sample_covid_19.sender.service;

import com.jordanec.rabbitmq_sample_covid_19.model.Update;
import com.jordanec.rabbitmq_sample_covid_19.sender.repository.UpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Service
public class UpdateService
{
    @Autowired
    CountryService countryService;

    @Autowired
    UpdateRepository updateRepository;

    @Transactional(value = REQUIRED)
    public void validateAndCreate(Update update) throws Exception
    {
        update.setLastUpdate(LocalDate.now());
        countryService.validateAndSave(update);
        updateRepository.save(update);
    }

    public void assignNextUpdateOfTheDay(Update update)
    {
        List<Update> updates = updateRepository
                .findByCountryNameAndLastUpdateOrderByUpdateOfTheDayDesc(update.getCountryName(),
                        update.getLastUpdate());
        if (CollectionUtils.isEmpty(updates))
        {
            update.setUpdateOfTheDay(1);
        }
        else
        {
            update.setUpdateOfTheDay(updates.get(0).getUpdateOfTheDay() + 1);
        }
    }
}