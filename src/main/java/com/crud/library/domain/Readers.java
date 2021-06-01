package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "READERS")
public class Readers
{
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "ACCOUNT_CREATION_DATE")
    private LocalDate accountCreationDate;

    public Readers(String name, String surname, int year, int month, int day) {
        this.name = name;
        this.surname = surname;
        this.accountCreationDate = LocalDate.of(year, month, day);
    }

    @OneToMany(
            targetEntity = BooksRent.class,
            mappedBy = "reader",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<BooksRent> booksRentListByReader = new ArrayList<>();
}
