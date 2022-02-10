package com.crud.library.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "READERS")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "reader")
public class Reader implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "READER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "ACCOUNT_CREATION_DATE")
    private LocalDate accountCreationDate;

    public Reader(Long id, String name, String surname, LocalDate accountCreationDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accountCreationDate = accountCreationDate;
    }

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rent> rentListReader = new ArrayList<>();
}
