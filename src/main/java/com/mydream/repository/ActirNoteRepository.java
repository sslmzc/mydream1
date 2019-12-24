package com.mydream.repository;

import com.mydream.doman.ActirNotes;
import com.mydream.doman.MydreamUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 张灿
 * @Time: 2019/11/27 19:47
 */
@Repository
public interface ActirNoteRepository extends JpaRepository<ActirNotes,Integer> {



    List<ActirNotes> findAllByUserIdEquals(Integer integer);



    @Transactional
    void deleteByNoteId(Integer integer);


    Optional<ActirNotes> findByUserIdEqualsAndActirIdEquals(Integer userId,Integer actirId);

    //    List<ActirNotes> findAll(Integer integer);
}
