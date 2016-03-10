package com.opensourceteams.theory.java.第十八章_Java_io_系统.对象序列化;

import java.io.Serializable;
import java.io.Serializable;
import java.util.Date;
/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  上午10:03
 * 功能描述:
 */

public class UserVo implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6846034858002233878L;

    private String userId;

    private String userName;

    private int age;

    private Date born;

    public UserVo() {
    }

    public UserVo(String userId, String userName, int age, Date born) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.born = born;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @return the born
     */
    public Date getBorn() {
        return born;
    }

    /**
     * @param pUserId the userId to set
     */
    public void setUserId(String pUserId) {
        userId = pUserId;
    }

    /**
     * @param pUserName the userName to set
     */
    public void setUserName(String pUserName) {
        userName = pUserName;
    }

    /**
     * @param pAge the age to set
     */
    public void setAge(int pAge) {
        age = pAge;
    }

    /**
     * @param pBorn the born to set
     */
    public void setBorn(Date pBorn) {
        born = pBorn;
    }

    @Override
    public String toString() {
        return "userId=[ " + userId + " ] userName=[ " + userName + " ] age=[ "
                + age + " ] born=[ " + born + "] .";
    }
}
