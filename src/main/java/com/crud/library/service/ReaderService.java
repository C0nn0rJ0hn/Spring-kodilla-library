package com.crud.library.service;

import com.crud.library.domain.Reader;
import com.crud.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService
{
    @Autowired
    private ReaderRepository readerRepository;

    //@CachePut(value = "allReaders", key = "'readers'")
    public Reader addReader(Reader reader) {
        return readerRepository.save(reader);
    }

    //@Cacheable(value = "allReaders")
    public List<Reader> getAllReaders()
    {
        return readerRepository.findAll();
    }

    //@Cacheable(value = "reader", key = "#readerId")
    public Optional<Reader> getReaderById(final Long readerId)
    {
        return readerRepository.findById(readerId);
    }

    //@CacheEvict(value = "reader", key = "#readerId")
    public void deleteReaderById(final Long readerId)
    {
        readerRepository.deleteById(readerId);
    }
}
