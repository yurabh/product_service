package com.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


//import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
//@Table(name = "products")
@Getter
public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
