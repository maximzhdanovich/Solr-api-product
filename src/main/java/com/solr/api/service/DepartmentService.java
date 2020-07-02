package com.solr.api.service;

import com.solr.api.model.Department;
import com.solr.api.repository.DepartmentRepository;
import com.solr.api.repository.ProductRepository;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DepartmentService {

    @Autowired
    private HttpSolrClient solrClient;


    public SolrDocumentList findByName(String dname) throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.set("q", "departmentTitle:"+ dname);
        QueryResponse response = solrClient.query(query);
        return response.getResults();
    }

    public SolrDocumentList getAll () throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery();
        query.set("q", "departmentTitle:*");
        QueryResponse response = solrClient.query(query);
        return response.getResults();
    }

}