package com.br.omnishop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.omnishop.models.Product;


@Repository // pour dire que c'est un repository pour le réutiliser ailleurs (dans le controller)
public interface ProductRepository extends JpaRepository<Product, Long> { // pour dire que c'est un repository de l'entité Product et que son primary key est un Long
    
}
