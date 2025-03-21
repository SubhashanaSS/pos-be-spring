package com.ss.springpos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Double price;

    private String description;
    
    private int qty;

    @ManyToOne
    @JoinColumn(name = "item_cate_id")
    private ItemCategory itemCategory;

    @JsonIgnore
    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private Stock stock;

    @JsonIgnore
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;
}
