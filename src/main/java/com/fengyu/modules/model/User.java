package com.fengyu.modules.model;


import com.fengyu.common.persistence.DataEntity;

import javax.inject.Named;
import javax.security.auth.Subject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.Principal;
import java.util.Date;

@XmlRootElement
public class User extends DataEntity<User> implements Principal {

    @NotNull
    private String nameLogin;

    private String email;

    private String pwdLogin;

    private Integer userType;
    private String phone;
    private Date timeCreate;
    private Date timeLastLogin;
    private Date timeLastLogout;
    private Boolean pwdRest;
    private Boolean isAuth;
    private Boolean isLocked;
    private String name;
    private  String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getLocked() {
        return isLocked;
    }

    public void setLocked(Boolean locked) {
        isLocked = locked;
    }

    public Boolean getAuth() {
        return isAuth;
    }

    public void setAuth(Boolean auth) {
        isAuth = auth;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameLogin() {
        return nameLogin;
    }

    public void setNameLogin(String nameLogin) {
        this.nameLogin = nameLogin == null ? null : nameLogin.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPwdLogin() {
        return pwdLogin;
    }

    public void setPwdLogin(String pwdLogin) {
        this.pwdLogin = pwdLogin == null ? null : pwdLogin.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public Date getTimeLastLogin() {
        return timeLastLogin;
    }

    public void setTimeLastLogin(Date timeLastLogin) {
        this.timeLastLogin = timeLastLogin;
    }

    public Date getTimeLastLogout() {
        return timeLastLogout;
    }

    public void setTimeLastLogout(Date timeLastLogout) {
        this.timeLastLogout = timeLastLogout;
    }

    public Boolean getPwdRest() {
        return pwdRest;
    }

    public void setPwdRest(Boolean pwdRest) {
        this.pwdRest = pwdRest;
    }

    public Boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(Boolean isAuth) {
        this.isAuth = isAuth;
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}