package com.ust.carts.Controller;
import com.ust.carts.Model.Carts;
import com.ust.carts.Repository.Cartsrepo;
import com.ust.carts.Service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class Cartscontroller {

    @Autowired
    private CartsService cartsService;


    @PostMapping
    public ResponseEntity<Carts> createUser(@RequestBody Carts cart) {
        Carts savedCart = cartsService.saveCart(cart);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<List<Carts>> getUser(@PathVariable("userid") Integer userid) {
        List<Carts> carts = cartsService.findByUserId(userid).orElse(null);
        if (carts != null) {
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{userid}")
    public ResponseEntity<Carts> updateUser(@PathVariable("userid") Integer userid, @RequestBody Carts cart) {
        Carts updatedCart = cartsService.updateCart(userid, cart);
        if (updatedCart != null) {
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userid}/{cartid}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userid") Integer userid, @PathVariable("cartid") Integer cartid) {
        boolean deleted = cartsService.deleteCart(userid, cartid);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Carts>> findAll() {
        List<Carts> carts = cartsService.findAllCarts();
        return ResponseEntity.status(HttpStatus.OK).body(carts);
    }



}
