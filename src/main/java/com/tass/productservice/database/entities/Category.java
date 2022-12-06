package com.tass.productservice.database.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.tass.productservice.utils.Constant;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Data
@Entity
@Table(name = "category")
public class Category{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String icon;

    private int isRoot;
    public boolean checkIsRoot(){
        return isRoot == Constant.ONOFF.ON;
    }

}
