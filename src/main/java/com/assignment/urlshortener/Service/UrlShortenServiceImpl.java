package com.assignment.urlshortener.Service;

import com.assignment.urlshortener.Algorithm.ShortURL;
import com.assignment.urlshortener.Commons.Constants;
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
        UrlShortenDto url_check;
        if((url.getUrl().startsWith("http://www.") || url.getUrl().startsWith("https://www.")) || (url.getUrl().startsWith("http://") || url.getUrl().startsWith("https://"))) {
            url_check = urlShortenRepository.checkUrl(url.getUrl().toLowerCase());
        }else{
            url_check = urlShortenRepository.checkUrl("http://"+url.getUrl().toLowerCase());
        }
        if(url_check == null){
            InetAddress inetAddress = InetAddress.getLocalHost();
            String urlHash = ShortURL.encode();
            System.out.println(urlHash);
            url.setId(urlHash);
            if((url.getUrl().startsWith("http://www.") || url.getUrl().startsWith("https://www.")) || (url.getUrl().startsWith("http://") || url.getUrl().startsWith("https://"))) {
                url.setUrl(url.getUrl().toLowerCase());
            }else{
                url.setUrl("http://"+url.getUrl().toLowerCase());
            }
            url.setShort_url("http://"+inetAddress.getHostAddress()+":"+Constants.SERVER_PORT_NUMBER+"/url/"+urlHash);
            if(urlShortenRepository.StoreUrl(url)){
            url_short = url.getShort_url();
            }else{
                url_short = "insert failed";
            }
        }else{
            url_short = url_check.getShort_url();
        }
        return url_short;
    }

    @Override
    public String fetchOriginalUrl(String id) {
        return urlShortenRepository.fetchOriginalUrl(id);
    }
}
