package com.solr.api.repository;

import com.solr.api.model.Product;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface ProductRepository extends SolrCrudRepository<Product, Integer>{


}
