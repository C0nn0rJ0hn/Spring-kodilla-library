package com.crud.library.repository;

import com.crud.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Cacheable(value = "readersCache")
@Transactional
@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long>
{
    //@CachePut(value = "reader", key = "#result.id")
    @Override
    Reader save(Reader reader);

    //@Cacheable(value = "allReaders")
    @Override
    List<Reader> findAll();

    //@Cacheable(value = "reader", key = "#id")
    @Override
    Optional<Reader> findById(Long id);

    //@CacheEvict(value = "reader")
    void deleteById(Long id);

}
