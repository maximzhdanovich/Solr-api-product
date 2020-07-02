package com.solr.api.config;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
//@EnableSolrRepositories(
//        basePackages = "com.solr.api.model",
//        namedQueriesLocation = "classpath:solr-named-queries.properties")
@ComponentScan
public class SolrConfig {

    @Bean
    public HttpSolrClient solrClient() {
        String urlString = "http://localhost:8983/solr/product";
        HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
        solr.setParser(new XMLResponseParser());
        return solr;
    }
//
//    @Bean
//    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
//        return new SolrTemplate(client);
//    }
}