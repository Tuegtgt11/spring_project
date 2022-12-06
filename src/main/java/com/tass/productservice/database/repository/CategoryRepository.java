package com.tass.productservice.database.repository;

import com.tass.productservice.database.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> , CategoryExtentRepository,JpaSpecificationExecutor<Category> {
    List<Category> findByName(String name);
}
