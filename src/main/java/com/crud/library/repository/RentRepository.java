package com.crud.library.repository;

import com.crud.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long>
{
    @Override
    Rent save(Rent bookRent);

    @Override
    List<Rent> findAll();

    @Override
    Optional<Rent> findById(Long id);

    void deleteById(Long id);

}
