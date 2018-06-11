package com.assignment.urlshortener.Repository;

import com.assignment.urlshortener.DTO.UrlShortenDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UrlShortenRepository{
      UrlShortenDto checkUrl(String url);
      boolean StoreUrl(UrlShortenDto url);
      String fetchOriginalUrl(String id);
}
