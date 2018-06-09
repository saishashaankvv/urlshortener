package com.assignment.urlshortener.controller;


import com.assignment.urlshortener.DTO.UrlShortenDto;
import com.assignment.urlshortener.Service.UrlShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@CrossOrigin
public class UrlShortenController {

    private final UrlShortenService urlShortenService;

    @Autowired
    public UrlShortenController(UrlShortenService urlShortenService) {
        this.urlShortenService = urlShortenService;
    }

    @RequestMapping(value = "/shorten", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private void shortenUrl(@RequestBody UrlShortenDto url){
        urlShortenService.shortenUrl(url);
    }
}
