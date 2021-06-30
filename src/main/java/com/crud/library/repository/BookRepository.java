package com.crud.library.repository;

import com.crud.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long>
{
    @Override
    Book save(Book title);

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long id);

    void deleteById(Long id);

    List<Book> findByPublishYear(int publishYear);
}
