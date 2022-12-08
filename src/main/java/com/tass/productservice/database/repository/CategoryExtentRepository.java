package com.tass.productservice.database.repository;

import com.tass.productservice.database.entities.Category;
import com.tass.productservice.model.response.SearchCategoryResponse;

import java.util.List;

public interface CategoryExtentRepository {
    void searchCategory(Integer isRoot , String name, Integer page, Integer pageSize, SearchCategoryResponse.Data data);
    List<Category> findCateByName(String query);
     List findAllParentAndChildByQuery(String query);

}
