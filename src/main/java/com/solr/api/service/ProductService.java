package com.solr.api.service;

import com.solr.api.repository.ProductRepository;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProductService {

    @Autowired
    private HttpSolrClient solrClient;

    @Autowired
    private ProductRepository repository;

    public SolrDocumentList findByName(String pname) throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.set("q", "productTitle:"+ pname);
        QueryResponse response = solrClient.query(query);
        return response.getResults();
    }

    public SolrDocumentList findByNameOnlyProduct(String pname) throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.set("q", "productTitle:* and id:" + Integer.valueOf(pname));
        QueryResponse response = solrClient.query(query);
        return response.getResults();
    }
    public SolrDocumentList getAll () throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.set("q", "productTitle:*");
        QueryResponse response = solrClient.query(query);
        return response.getResults();
    }
}
