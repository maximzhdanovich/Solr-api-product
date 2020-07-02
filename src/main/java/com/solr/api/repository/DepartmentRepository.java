package com.solr.api.repository;

import com.solr.api.model.Department;
import com.solr.api.model.Product;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface DepartmentRepository extends SolrCrudRepository<Department, Integer> {

}
