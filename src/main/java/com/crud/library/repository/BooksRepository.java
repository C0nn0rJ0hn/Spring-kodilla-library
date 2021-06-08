package com.crud.library.repository;

import com.crud.library.domain.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends CrudRepository<Books, Long>
{
    @Override
    Books save(Books book);

    @Override
    List<Books> findAll();

    @Override
    Optional<Books> findById(Long id);

    void deleteById(Long id);
}
