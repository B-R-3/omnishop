package com.br.omnishop.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // pour dire que cela est une table SQL
@Table(name = "products")
@Getter
@Setter 
@NoArgsConstructor 
@AllArgsConstructor // pour les getters et setters et les constructeurs par Lombok

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pour générer comme il faut l'id de product
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price; // BigDecimal pour les prix en spring boot

    private int stockQuantity;
}
