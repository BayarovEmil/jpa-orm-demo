package com.example.jpa_orm_demo.repository;

import com.example.jpa_orm_demo.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPu");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Product save() {
        entityManager.getTransaction().begin();
        Product product = new Product();
        product.setName("Product Name");
        product.setPrice(12.6);
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        return product;
    }

    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    public Product updateById(int id) {
        Product retrievedProduct = entityManager.find(Product.class, id);
        entityManager.getTransaction().begin();
        retrievedProduct.setPrice(25);
        entityManager.getTransaction().commit();
        return retrievedProduct;
    }

    public void deleteById(int id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

}
