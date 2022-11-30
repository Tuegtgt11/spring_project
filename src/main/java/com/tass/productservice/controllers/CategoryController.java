package com.tass.productservice.controllers;

import com.tass.productservice.database.entities.Category;
import com.tass.productservice.model.ApiException;
import com.tass.productservice.model.BaseResponse;
import com.tass.productservice.model.ERROR;
import com.tass.productservice.model.request.CategoryRequest;

import com.tass.productservice.services.CategoryService;
import com.tass.productservice.spec.Specifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController{

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCate(@RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "description", required = false) String description,
                                     @RequestParam(value = "icon", required = false) String icon) throws ApiException{
        Specification<Category> specification = Specifications.cateSpec(name, description, icon);
        return categoryService.getAll(specification);
    }

    @GetMapping("/{id}")
    ResponseEntity<BaseResponse> findById(@PathVariable Long id){
        return categoryService.findById(id);
    }
    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CategoryRequest request)throws
        ApiException {
        return createdResponse(categoryService.createCategory(request));
    }
    @PutMapping("/{id}")
    ResponseEntity<BaseResponse> updateCate(@PathVariable Long id, CategoryRequest request)throws ApiException{
        return createdResponse(categoryService.updateCate(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id)throws
        ApiException {
        return createdResponse(categoryService.deleteCategory(id));
    }
}
