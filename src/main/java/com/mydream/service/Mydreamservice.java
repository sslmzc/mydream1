package com.mydream.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 张灿
 * @Time: 2019/11/28 11:37
 */
@Service
public class Mydreamservice {

    @Transactional
    public String isNull(String thenew , String theold){
        if (thenew == null){
            return theold;
        }else {
            return thenew;
        }
    }



    @Transactional
    public Integer isNull(Integer thenew,Integer theold){
        if (thenew == null){
            return theold;
        }else {
            return thenew;
        }
    }


}
