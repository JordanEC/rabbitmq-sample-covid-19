package com.jordanec.rabbitmq_sample_covid_19.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity(name = "_UPDATE")
public class Update implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Size(min = 2, max = 2)
    @NotNull
    @Column
    String continent;
    @Column
    @Size(min = 3, max = 3)
    @NotNull
    String countryName;
    @NotNull
    @Column
    Long cases;
    @NotNull
    @Column
    Long deaths;
    @NotNull
    @Column
    Long recovered;
    @Column
    Integer updateOfTheDay;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate lastUpdate;

    @Transient
    Country country;
}
