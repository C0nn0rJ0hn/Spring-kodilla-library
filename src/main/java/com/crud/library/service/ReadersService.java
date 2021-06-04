package com.crud.library.service;

import com.crud.library.domain.Readers;
import com.crud.library.repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReadersService
{
    @Autowired
    private ReadersRepository readersRepository;

    public Readers addReader(Readers reader)
    {
        return readersRepository.save(reader);
    }

    public List<Readers> getAllReaders()
    {
        return readersRepository.findAll();
    }

    public Optional<Readers> getReaderById(final Long readerId)
    {
        return readersRepository.findById(readerId);
    }

    public void deleteReaderById(final Long readerId)
    {
        readersRepository.deleteById(readerId);
    }
}
