package com.ss.springpos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private String name;
    private Double price;

    private  String description;

    private Long itemCateId;
}
