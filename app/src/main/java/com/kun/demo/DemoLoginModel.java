package com.kun.demo;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DemoLoginModel {
    @Id
    private long keyId;
    private String mobile;
    private String password;
    @Generated(hash = 401854101)
    public DemoLoginModel(long keyId, String mobile, String password) {
        this.keyId = keyId;
        this.mobile = mobile;
        this.password = password;
    }
    @Generated(hash = 1164878618)
    public DemoLoginModel() {
    }
    public long getKeyId() {
        return this.keyId;
    }
    public void setKeyId(long keyId) {
        this.keyId = keyId;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
