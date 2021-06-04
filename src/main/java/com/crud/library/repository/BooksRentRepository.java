package com.crud.library.repository;

import com.crud.library.domain.BooksRent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRentRepository extends CrudRepository<BooksRent, Long>
{
    @Override
    BooksRent save(BooksRent bookRent);

    @Override
    List<BooksRent> findAll();

    @Override
    Optional<BooksRent> findById(Long id);

    void deleteById(Long id);

}
