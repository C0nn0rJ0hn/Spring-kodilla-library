package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@Entity(name = "Readers")
public class Readers
{
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "account_creation_date")
    private LocalDate accountCreationDate;

    public Readers(String name, String surname, LocalDate accountCreationDate) {
        this.name = name;
        this.surname = surname;
        this.accountCreationDate = accountCreationDate;
    }
}
