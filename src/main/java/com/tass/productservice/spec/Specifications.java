package com.tass.productservice.spec;


import com.tass.productservice.database.entities.Category;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

public class Specifications {
    public static Specification<Category> cateSpec(String name, String description, String icon){
        return ((root, query, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            if (name != null &&  !(name.isEmpty()))
                predicates.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
            if (description != null &&  !(description.isEmpty()))
                predicates.add(criteriaBuilder.like(root.get("description"),"%"+description+"%"));
            if (icon != null &&  !(icon.isEmpty()))
                predicates.add(criteriaBuilder.like(root.get("icon"),"%"+icon+"%"));
            return criteriaBuilder.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
        });
    }
}
