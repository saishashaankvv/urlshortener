package com.assignment.urlshortener.Service;

import com.assignment.urlshortener.Algorithm.ShortURL;
import com.assignment.urlshortener.DTO.UrlShortenDto;
import com.assignment.urlshortener.Repository.UrlShortenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class UrlShortenServiceImpl implements UrlShortenService{

    private final UrlShortenRepository urlShortenRepository;

    @Autowired
    public UrlShortenServiceImpl(UrlShortenRepository urlShortenRepository) {
        this.urlShortenRepository = urlShortenRepository;
    }

    @Override
    public String shortenUrl(UrlShortenDto url) throws UnknownHostException {
        String url_short;
        UrlShortenDto url_check = urlShortenRepository.checkUrl(url.getUrl());
        if(url_check == null){
            InetAddress inetAddress = InetAddress.getLocalHost();
            url.setId(ShortURL.encode());
            url.setShort_url("http://"+inetAddress.getHostAddress()+"/"+url.getId());
            System.out.println("url_short = "+url.getShort_url());
            if(urlShortenRepository.StoreUrl(url)){
            url_short = url.getShort_url();
            }else{
                url_short = "insert failed";
            }
        }else{
            System.out.println("URL has been used before. Fetch it and send it to Front End");
            url_short = url_check.getShort_url();
        }
        return url_short;
    }
}
