package com.studio.builder.model;import javax.persistence.Table;/** * description: * author:          song * createDate:      2017/10/25 */@Table(name = "studio_User")public class User extends  BaseModel {    private String userName;    private String realName;    private String password;    private boolean isAdmin;    private String ipAddress;    private String macAddress;    private String email;    private boolean enabled;    public String getUserName() {        return userName;    }    public void setUserName(String userName) {        this.userName = userName;    }    public String getRealName() {        return realName;    }    public void setRealName(String realName) {        this.realName = realName;    }    public String getPassword() {        return password;    }    public void setPassword(String password) {        this.password = password;    }    public boolean isAdmin() {        return isAdmin;    }    public void setAdmin(boolean admin) {        isAdmin = admin;    }    public String getIpAddress() {        return ipAddress;    }    public void setIpAddress(String ipAddress) {        this.ipAddress = ipAddress;    }    public String getMacAddress() {        return macAddress;    }    public void setMacAddress(String macAddress) {        this.macAddress = macAddress;    }    public String getEmail() {        return email;    }    public void setEmail(String email) {        this.email = email;    }    public boolean isEnabled() {        return enabled;    }    public void setEnabled(boolean enabled) {        this.enabled = enabled;    }}