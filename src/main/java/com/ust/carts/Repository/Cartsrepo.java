package com.ust.carts.Repository;

import com.ust.carts.Model.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface Cartsrepo extends JpaRepository<Carts,Integer> {


   Optional<List<Carts>> findByUserid(Integer userid);

    

    void deleteByUserid(Integer userid);


    boolean existsByCartid(Integer cartid);

    boolean existsByUserid(Integer userid);
}
