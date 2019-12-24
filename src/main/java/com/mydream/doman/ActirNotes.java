package com.mydream.doman;

import javax.persistence.*;


/**
 * @Author: 张灿
 * @Time: 2019/11/27 14:39
 */
@Entity
public class ActirNotes {




    @Id
    @GeneratedValue
    private Integer noteId;

    /**
     * 记录时间
     */

    private String data;

    /**
     * 用户名
     */


    @GeneratedValue
    private Integer userId;


    /**
     * 活动名
     */


    @GeneratedValue
    private Integer actirId;

    /**
     * 完成情况
     */
    private String process;




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




    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public Integer getNoteId() {
        return noteId;
    }


    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    @Override
    public String toString() {
        return "ActirNotes{" +
                "noteId=" + noteId +
                ", data='" + data + '\'' +
                ", userId=" + userId +
                ", actirId=" + actirId +
                ", process='" + process + '\'' +
                '}';
    }
}
