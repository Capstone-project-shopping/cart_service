package com.ust.carts.VO;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Product {


    private Integer id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
}
