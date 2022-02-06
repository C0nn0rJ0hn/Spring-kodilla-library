package com.crud.library.repository;

import com.crud.library.domain.Reader;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Cacheable(value = "readersCache")
@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long>
{
    @Override
    Reader save(Reader reader);

    @Override
    List<Reader> findAll();

    @Override
    Optional<Reader> findById(Long id);


    void deleteById(Long id);

}
