package com.assignment.urlshortener.Repository;

import com.assignment.urlshortener.Commons.Constants;
import com.assignment.urlshortener.Config.MongoDBConfig;
import com.assignment.urlshortener.DTO.UrlShortenDto;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UrlShortenRepositoryImpl implements UrlShortenRepository {
    @Override
    public UrlShortenDto checkUrl(String url) {
        Query query = new Query(Criteria.where("url").is(url.toLowerCase()));
        return MongoDBConfig.getMongoTemplate().findOne(query,UrlShortenDto.class,Constants.URL_COLLECTION);
    }

    @Override
    public boolean StoreUrl(UrlShortenDto url) {
        try {
            MongoDBConfig.getMongoTemplate().insert(url, Constants.URL_COLLECTION);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public String fetchOriginalUrl(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return MongoDBConfig.getMongoTemplate().findOne(query,UrlShortenDto.class,Constants.URL_COLLECTION).getUrl();
    }
}
