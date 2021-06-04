package com.crud.library.service;

import com.crud.library.domain.Titles;
import com.crud.library.repository.TitlesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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

    public Optional<Titles> getTitlesByPublishYear(final int publishYear)
    {
        return titlesRepository.findByPublishYear(publishYear);
    }
}
