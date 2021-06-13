package com.crud.library.mapper;

import com.crud.library.domain.Books;
import com.crud.library.domain.BooksDto;
import com.crud.library.domain.Titles;
import com.crud.library.domain.TitlesDto;
import com.crud.library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitlesMapper
{
    public Titles mapToTitles(final TitlesDto titlesDto)
    {
        return new Titles(
                titlesDto.getId(),
                titlesDto.getTitle(),
                titlesDto.getAuthor(),
                titlesDto.getPublishYear(),
                titlesDto.getListBooks()
        );
    }

    public TitlesDto mapToTitlesDto(final Titles titles)
    {
        return new TitlesDto(
                titles.getId(),
                titles.getAuthor(),
                titles.getTitle(),
                titles.getPublishYear(),
                titles.getBooksList()
        );
    }

    public List<TitlesDto> mapToTitlesDtoList(final List<Titles> titlesList)
    {
        return titlesList.stream()
                .map(this::mapToTitlesDto)
                .collect(Collectors.toList());
    }
}
