package com.mydream.repository;

import com.mydream.doman.MydreamActir;
import com.mydream.doman.MydreamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 张灿
 * @Time: 2019/11/25 15:21
 */
@Repository
public interface UserRepository extends JpaRepository<MydreamUser,Integer> {




    Optional<MydreamUser> findByUsername(String username);
}
