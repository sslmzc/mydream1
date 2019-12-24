package com.mydream.repository;

import com.mydream.doman.MydreamActir;
import com.mydream.doman.MydreamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: 张灿
 * @Time: 2019/11/27 15:35
 */
@Repository
public interface ActirRepository extends JpaRepository<MydreamActir,Integer> {


    Optional<MydreamActir> findAllByNameEquals(String string);

}
