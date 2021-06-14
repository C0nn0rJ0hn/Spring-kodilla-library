package com.crud.library.repository;

import com.crud.library.domain.BookCopy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Long>
{
    @Override
    BookCopy save(BookCopy book);

    @Override
    List<BookCopy> findAll();

    @Override
    Optional<BookCopy> findById(Long id);

    void deleteById(Long id);
}
