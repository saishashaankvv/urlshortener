package com.assignment.urlshortener.controller;


import com.assignment.urlshortener.DTO.UrlShortenDto;
import com.assignment.urlshortener.Service.UrlShortenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.awt.*;
import java.net.UnknownHostException;

@RestController
@CrossOrigin
public class UrlShortenController {

    private final UrlShortenService urlShortenService;

    @Autowired
    public UrlShortenController(UrlShortenService urlShortenService) {
        this.urlShortenService = urlShortenService;
    }

    @RequestMapping(value = "/shorten", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity shortenUrl(@RequestBody UrlShortenDto url) throws UnknownHostException {
        String shortUrl = urlShortenService.shortenUrl(url);
        System.out.println(shortUrl);
        if(shortUrl.equals("insertion failed")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"url\":\"insertion_failed\"}");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("{\"url\":\""+shortUrl+"\"}");
        }
    }
}
