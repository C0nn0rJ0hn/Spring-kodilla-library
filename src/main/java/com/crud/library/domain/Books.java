package com.crud.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Book_Copies")
public class Books
{
    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "book_title_id")
    private Titles bookTitle;

    public Books(String status) {
        this.status = status;
    }
}
