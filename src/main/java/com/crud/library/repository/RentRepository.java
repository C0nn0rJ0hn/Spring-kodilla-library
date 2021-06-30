package com.crud.library.repository;

import com.crud.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RentRepository extends CrudRepository<Rent, Long>
{
    @Override
    Rent save(Rent rent);

    @Override
    List<Rent> findAll();

    @Override
    Optional<Rent> findById(Long rentedBookCopyId);

    void deleteById(Long rentId);
}
