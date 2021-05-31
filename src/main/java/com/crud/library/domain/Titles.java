package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Titles")
public class Titles
{
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "publish_year")
    private int publishYear;


    @OneToMany(
            targetEntity = Books.class,
            mappedBy = "bookTitle",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Books> booksList = new ArrayList<>();

    public Titles(String title, String author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }
}