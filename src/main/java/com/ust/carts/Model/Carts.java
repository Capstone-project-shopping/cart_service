package com.ust.carts.Model;

import com.ust.carts.VO.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carts   {

    @Id
//    @GeneratedValue
    private Integer cartid;
    private Integer userid;
   @ElementCollection
   private List<Product> cartItems;

}
