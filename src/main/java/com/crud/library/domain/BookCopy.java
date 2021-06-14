package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "BOOK_COPIES")
public class BookCopy
{
    @Id
    @GeneratedValue
    @Column(name = "BOOK_COPY_ID")
    private Long id;

    @Column(name = "STATUS", columnDefinition = "enum('AVAILABLE', 'DESTROYED', 'LOST', 'RENTED')")
    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOK_RENT_ID")
    private Rent rent;
}
