package com.jordanec.rabbitmq_sample_covid_19.sender.repository;

import com.jordanec.rabbitmq_sample_covid_19.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>
{
    Country getByName(String name);
}
