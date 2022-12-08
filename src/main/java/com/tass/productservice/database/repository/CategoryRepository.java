package com.tass.productservice.database.repository;

import com.tass.productservice.database.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> , CategoryExtentRepository,JpaSpecificationExecutor<Category> {
    List<Category> findByName(String name);
    @Query(value = "select * from category c, category_relationship cr where c.id = cr.id and ",nativeQuery = true)
    List<Category> findAllChildrenBySelect(Long id);

    @Query(value = "select * from category c, category_relationship cr where c.id = cr.link_id",nativeQuery = true)
    List<Category> findAllParentBySelect(Long id);
}
