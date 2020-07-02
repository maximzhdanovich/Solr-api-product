package com.solr.api.controller;

import com.solr.api.model.Product;
import com.solr.api.repository.ProductRepository;
import com.solr.api.repository.ProductRepository;
import com.solr.api.service.DepartmentService;
import com.solr.api.service.ProductService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getALL")
    public String getProducts(Model model) throws IOException, SolrServerException {
        model.addAttribute("products",productService.getAll());
        model.addAttribute("departments",departmentService.getAll());
        return "main";
    }

    @PostMapping("/getALL")
    public String getProductsByName(Model model, @RequestParam Map<String, String> form) throws IOException, SolrServerException {
        String name = form.get("name");
        if (name != null && !name.equals("")) {
            model.addAttribute("products", productService.findByName(name));
            model.addAttribute("departments", departmentService.findByName(name));
            return "main";
        }
        return "redirect:/getALL";
    }


}
