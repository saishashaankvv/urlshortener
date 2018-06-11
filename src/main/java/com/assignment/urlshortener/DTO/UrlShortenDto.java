package com.assignment.urlshortener.DTO;

import com.assignment.urlshortener.Commons.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Document(collection = Constants.URL_COLLECTION)
public class UrlShortenDto implements Serializable {

    @Id
    private String id;
    private String url;
    private String short_url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "url{" +
                ", id='" + id + '\'' +
                ", url=" + url +
                ", short_url=" +short_url +
                '}';
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public String getShort_url(){
        return short_url;
    }

}
