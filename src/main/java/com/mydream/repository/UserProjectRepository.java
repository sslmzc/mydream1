package com.mydream.repository;

import com.mydream.doman.UserProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: 张灿
 * @Time: 2019/11/30 15:56
 */
@Repository
public interface UserProjectRepository extends JpaRepository<UserProject,Integer> {


}
