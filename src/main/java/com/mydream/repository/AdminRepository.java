package com.mydream.repository;

import com.mydream.doman.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: 张灿
 * @Time: 2019/11/30 15:19
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {


}
