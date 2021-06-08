package com.crud.library.controller;

import com.crud.library.domain.Titles;
import com.crud.library.domain.TitlesDto;
import com.crud.library.exceptions.TitleNotFoundException;
import com.crud.library.mapper.TitlesMapper;
import com.crud.library.service.TitlesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/library/titles")
public class TitlesController
{
    private final TitlesMapper mapper;
    private final TitlesService service;

    @GetMapping(value = "/getTitles")
    public List<TitlesDto> getTitles()
    {
        List<Titles> titlesList = service.getAllTitles();
        return mapper.mapToTitlesDtoList(titlesList);
    }

    @GetMapping(value = "/getTitle")
    public TitlesDto getTitleById(@RequestParam Long titleId) throws TitleNotFoundException
    {
        return mapper.mapToTitlesDto(service.getTitleById(titleId).orElseThrow(TitleNotFoundException::new));
    }

    @PostMapping(value = "/addTitle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addTitle(@RequestBody TitlesDto titlesDto)
    {
        service.addTitle(mapper.mapToTitles(titlesDto));
    }

    @DeleteMapping(value = "/deleteTitle")
    public void deleteTitle(@RequestParam Long titleId)
    {
        service.deleteTitleById(titleId);
    }

    @PutMapping(value = "/updateTitle")
    public TitlesDto updateTitle(@RequestBody TitlesDto titlesDto)
    {
        Titles title = mapper.mapToTitles(titlesDto);
        Titles savedTitle = service.addTitle(title);
        return mapper.mapToTitlesDto(savedTitle);
    }

    @GetMapping(value = "getTitlesByYear")
    public List<TitlesDto> getTitlesByPublishYear(@RequestParam int year)
    {
        List<Titles> titlesListByYear = service.getTitlesByPublishYear(year);
        return mapper.mapToTitlesDtoList(titlesListByYear);
    }
}
