package com.mydream.doman;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: 张灿
 * @Time: 2019/11/27 14:45
 */
@Entity
public class UserProject {

    /**
     * 用户名
     */
    @Id
    @GeneratedValue
    private Integer actirId;


    /**
     * 活动名
     */
    @GeneratedValue
    private String actirName;


    private Integer userId;

    /**
     * 个人活动要求
     */
    private String need;

    /**
     * 活动报酬
     */
    private String reward;

    public Integer getActirId() {
        return actirId;
    }

    public void setActirId(Integer actirId) {
        this.actirId = actirId;
    }

    public String getActirName() {
        return actirName;
    }

    public void setActirName(String actirName) {
        this.actirName = actirName;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserProject{" +
                "actirId='" + actirId + '\'' +
                ", actirName='" + actirName + '\'' +
                ", userId='" + userId + '\'' +
                ", need='" + need + '\'' +
                ", reward='" + reward + '\'' +
                '}';
    }
}
