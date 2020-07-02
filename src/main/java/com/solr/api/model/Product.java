package com.solr.api.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.Id;

@SolrDocument(collection = "product")
public class Product {

	public Product() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public Product(int id, String productTitle, int department_id) {
		this.id = id;
		this.productTitle = productTitle;
		this.department_id = department_id;
	}

	@Id
	@Field
	private int id;

	@Field
	private String productTitle;

	@Field
	private int department_id;

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
}
