package com.mydream.doman;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: 张灿
 * @Time: 2019/11/27 14:19
 */
@Entity
public class Admin {

    /**
     * 管理员账号
     */

    @Id
    @GeneratedValue
    private Integer adminId;

    private String num;

    /**
     * 管理员密码
     */
    private String passwd;

    /**
     * 管理员权限
     */
    private String perm;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", num='" + num + '\'' +
                ", passwd='" + passwd + '\'' +
                ", perm='" + perm + '\'' +
                '}';
    }
}
