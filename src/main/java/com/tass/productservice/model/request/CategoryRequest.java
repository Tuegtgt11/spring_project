package com.tass.productservice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tass.productservice.utils.Constant;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CategoryRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String icon;
    private String description;
    @JsonProperty("is_root")
    private Integer isRoot;
    @JsonProperty("parent_id")
    private Long parentId;


    public boolean checkIsRoot(){
        return isRoot != null && isRoot == Constant.ONOFF.ON;
    }
}
