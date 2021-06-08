package com.crud.library.service;

import com.crud.library.domain.Titles;
import com.crud.library.repository.TitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitlesService
{
    @Autowired
    private TitlesRepository titlesRepository;

    public Titles addTitle(Titles title)
    {
        return titlesRepository.save(title);
    }

    public List<Titles> getAllTitles()
    {
        return titlesRepository.findAll();
    }

    public void deleteTitleById(final Long titleId)
    {
        titlesRepository.deleteById(titleId);
    }

    public Optional<Titles> getTitleById(final Long titleId)
    {
        return titlesRepository.findById(titleId);
    }

    public List<Titles> getTitlesByPublishYear(final int publishYear)
    {
        return titlesRepository.findByPublishYear(publishYear);
    }
}
