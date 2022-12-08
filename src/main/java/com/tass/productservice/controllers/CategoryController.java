package com.tass.productservice.controllers;

import com.tass.productservice.database.entities.Category;
import com.tass.productservice.model.ApiException;
import com.tass.productservice.model.BaseResponse;
import com.tass.productservice.model.request.CategoryRequest;
import com.tass.productservice.model.response.SearchCategoryResponse;
import com.tass.productservice.services.CategoryService;
import com.tass.productservice.spec.Specifications;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "description", required = false) String description,
                                 @RequestParam(value = "icon", required = false) String icon) {
        Specification<Category> specification = Specifications.cateSpec(name, description, icon);
        return categoryService.getAll(specification);
    }

    @GetMapping
    public SearchCategoryResponse search(@RequestParam(name = "is_root", required = false) Integer isRoot, @RequestParam(required = false) String name,
                                         @RequestParam(required = false) Integer page, @RequestParam(name = "page_size", required = false) Integer pageSize) {
        return categoryService.search(isRoot, name, page, pageSize);
    }

    @GetMapping("/{id}")
    ResponseEntity<BaseResponse> findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody CategoryRequest request) throws
            ApiException {
        return createdResponse(categoryService.createCategory(request));
    }

    @PutMapping("/{id}")
    ResponseEntity<BaseResponse> updateCate(@PathVariable Long id, @RequestBody CategoryRequest request) throws ApiException {
        return createdResponse(categoryService.editCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) throws
            ApiException {
        return createdResponse(categoryService.deleteCategory(id));
    }

    @GetMapping(path = "/children")
    public ResponseEntity<BaseResponse> searchAllChild(@RequestParam(name = "name", required = false) String name) {
        return createdResponse(categoryService.findAllChildrenByQuery(name), HttpStatus.OK);
    }

    @GetMapping(path = "/all/{id}")
    public ResponseEntity<BaseResponse> searchAllParentAndChild(@PathVariable Long id) {
        return createdResponse(categoryService.findAllParentAndChildById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/name")
    public ResponseEntity<BaseResponse> searchAllParentAndChild(@RequestParam(name = "name", required = false) String name) {
        return createdResponse(categoryService.findAllParentAndChildByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/parent")
    public ResponseEntity<BaseResponse> searchAllParent(@RequestParam(name = "name", required = false) String name) {
        return createdResponse(categoryService.findAllParentByQuery(name), HttpStatus.OK);
    }

    @GetMapping(path = "/view/{id}")
    public ResponseEntity<BaseResponse> findALlWithView(@PathVariable Long id) {
        return createdResponse(categoryService.findAllParentAndChildWithView(id));
    }
}
