package com.mydream.doman;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: 张灿
 * @Time: 2019/11/27 14:32
 */
@Entity
public class MydreamActir {


    /**
     * 活动名称
     */
    @Id
    @GeneratedValue
    private Integer actirId;


    @GeneratedValue
    private Integer userId;

    private String name;

    /**
     * h活动地点
     */
    private String place;


    /**
     * 参赛人数
     */
    private Integer num;


    /**
     * 人员分工
     */
    private String job;


    /**
     * 报名资格
     */
    private String qua;


    /**
     *活动奖励
     */
    private String reward;


    /**
     * 是否通过审核,为1为通过,为0为未通过
     */
    private String allow;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActirId() {
        return actirId;
    }

    public void setActirId(Integer actirId) {
        this.actirId = actirId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "MydreamActir{" +
                "actirId=" + actirId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", num=" + num +
                ", job='" + job + '\'' +
                ", qua='" + qua + '\'' +
                ", reward='" + reward + '\'' +
                ", allow='" + allow + '\'' +
                '}';
    }
}
