package com.solr.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "product")
public class Department {

    @Id
    @Field
    private int id;

    @Field
    private String address;

    @Field
    private int foundationYear;


    @Field
    private String departmentTitle;
}
