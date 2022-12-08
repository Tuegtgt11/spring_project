package com.tass.productservice.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;
import com.tass.productservice.database.entities.Category;
import lombok.*;

import javax.persistence.Lob;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryInfo {
    private Integer id;
    private String name;
    private String description;
    private String icon;
    private Date created_at;
    private Date updated_at;
    private int is_root;
    @Lob
    private Set<Category> child;
    @Lob
    private Set<Category> parent;

    public void setChild(String child) {
        Gson gson = new Gson();
        Set<Category> childSet = gson.fromJson(child, Set.class);
        this.child = childSet;
    }

    public void setParent(String parent) {
        Gson gson = new Gson();
        Set<Category> parentSet = gson.fromJson(parent, Set.class);
        this.parent = parentSet;
    }

}
