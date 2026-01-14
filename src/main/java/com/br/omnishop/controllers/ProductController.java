package com.br.omnishop.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.omnishop.services.ProductService;
import com.br.omnishop.models.Product;

@RestController // dit a spring boot que c'est une API REST
@RequestMapping("/api/products") // L'URL DE BASE POUR CE CONTROLLER
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping // pour récupérer tous les produits
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }

    @PostMapping // Répond aux requêtes POST sur /api/products
    public Product createProduct(@RequestBody Product product) {
        // @RequestBody dit à Spring de transformer le JSON reçu en objet Product
        return productService.createProduct(product); // sauvegarde le produit dans la base de données
    }
}