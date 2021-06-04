package com.crud.library.repository;

import com.crud.library.domain.Readers;
import lombok.Builder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReadersRepository extends CrudRepository<Readers, Long>
{
    @Override
    Readers save(Readers reader);

    @Override
    List<Readers> findAll();

    @Override
    Optional<Readers> findById(Long id);


    void deleteById(Long id);

}
