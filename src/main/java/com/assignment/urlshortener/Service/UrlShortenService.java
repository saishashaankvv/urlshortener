package com.assignment.urlshortener.Service;

import com.assignment.urlshortener.DTO.UrlShortenDto;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;


public interface UrlShortenService {
     String shortenUrl(UrlShortenDto url) throws UnknownHostException;
     String fetchOriginalUrl(String id);
}
