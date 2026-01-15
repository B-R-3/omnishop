package com.br.omnishop.services;

import com.br.omnishop.models.Product;
import com.br.omnishop.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // pour dire que c'est un service pour le réutiliser ailleurs (dans le controller)
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // récupère tous les produits de la base de données
    }
    public Product createProduct(Product product) {
        return productRepository.save(product); // sauvegarde le produit dans la base de données
    }
}
