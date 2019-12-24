package com.mydream.doman;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

/**
 * @Author: 张灿
 * @Time: 2019/11/25 15:11
 */
@Entity
public class MydreamUser   {


    /**
     * 用户id
     */

    @Id
    @GeneratedValue
    private Integer userId;

    /**
     * 用户名字
     */

    private String username;

    /**
     * 用户真实姓名
     */
    private String real_name;


    /**
     * 用户角色
     */

    private String roles;

    /**
     * 用户联系方式
     */
    private String tel;

    /**
     * 用户性别
     */
    private String sex;


    /**
     * 用户学历
     */
    private String edu;

    /**
     * 用户特长
     */
    private String tal;


    /**
     * 个人留言
     */
    private String word;

    /**
     *用户积分
     */
    private Integer sco;


    /**
     * 用户密码
     */

    private String password;

    /**
     * 个人介绍
     */

    private Integer stuid;

    /**
     * 用户年龄
     */

    private Integer old;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getTal() {
        return tal;
    }

    public void setTal(String tal) {
        this.tal = tal;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getSco() {
        return sco;
    }

    public void setSco(Integer sco) {
        this.sco = sco;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    @Override
    public String toString() {
        return "MydreamUser{" +
                "userId=" + userId +
                ", name='" + username + '\'' +
                ", real_name='" + real_name + '\'' +
                ", tel='" + tel + '\'' +
                ", sex='" + sex + '\'' +
                ", edu='" + edu + '\'' +
                ", tal='" + tal + '\'' +
                ", word='" + word + '\'' +
                ", sco=" + sco +
                ", stuid=" + stuid +
                ", old=" + old +
                '}';
    }
}
