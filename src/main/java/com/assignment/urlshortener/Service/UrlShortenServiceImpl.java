package com.assignment.urlshortener.Service;

import com.assignment.urlshortener.DTO.UrlShortenDto;
import com.assignment.urlshortener.Repository.UrlShortenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenServiceImpl implements UrlShortenService{

    private final UrlShortenRepository urlShortenRepository;

    @Autowired
    public UrlShortenServiceImpl(UrlShortenRepository urlShortenRepository) {
        this.urlShortenRepository = urlShortenRepository;
    }

    @Override
    public void shortenUrl(UrlShortenDto url) {
        if(urlShortenRepository.checkUrl(url.getUrl()) == null){
            System.out.println("New URL, Not a duplicate. Encode and store");
        }else{
            System.out.println("URL has been used before. Fetch it and send it to Front End");
        }
    }
}
