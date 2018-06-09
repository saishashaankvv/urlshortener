package com.assignment.urlshortener.Service;

import com.assignment.urlshortener.DTO.UrlShortenDto;
import org.springframework.stereotype.Service;


public interface UrlShortenService {
     void shortenUrl(UrlShortenDto url);
}
