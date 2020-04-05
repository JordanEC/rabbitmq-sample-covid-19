package com.jordanec.rabbitmq_sample_covid_19.sender.repository;

import com.jordanec.rabbitmq_sample_covid_19.model.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UpdateRepository extends JpaRepository<Update, Integer>
{
    List<Update> findByCountryNameAndLastUpdateOrderByUpdateOfTheDayDesc(String countryName, LocalDate lastUpdate);
}
