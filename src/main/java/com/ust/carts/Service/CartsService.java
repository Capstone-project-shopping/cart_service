package com.ust.carts.Service;
import com.ust.carts.Model.Carts;
import com.ust.carts.Repository.Cartsrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartsService {

    @Autowired

    private Cartsrepo cartsrepo;

    public Carts saveCart(Carts cart) {
        return cartsrepo.save(cart);
    }



    public Optional<List<Carts>> findByUserId(Integer userId) {
        return cartsrepo.findByUserid(userId);
    }

    public Carts updateCart(Integer userId, Carts cart) {
        if (cartsrepo.existsByUserid(userId)) {
            cart.setUserid(userId);
            return cartsrepo.save(cart);
        } else {
            return null;
        }
    }

    public boolean deleteCart(Integer userId, Integer cartId) {
        if (cartsrepo.existsByUserid(userId)) {
            Optional<List<Carts>> cartsOptional = cartsrepo.findByUserid(userId);
            List<Carts> carts = cartsOptional.orElse(null);
            if (carts != null) {
                for (Carts cart : carts) {
                    if (cart.getCartid() == cartId) {
                        cartsrepo.deleteById(cartId);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Carts> findAllCarts() {
        return cartsrepo.findAll();
    }

}

