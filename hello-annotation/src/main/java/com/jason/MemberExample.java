package com.jason;

import com.jason.annotations.*;

import java.sql.Date;

@DBTable(name = "MEMBER")
public class MemberExample {
    @SQLInt(name = "ID", constraints = @Constraints(primaryKey = true))
    private Long id;

    @SQLVarchar(name = "ACCOUNT")
    private String account;

    @SQLVarchar(value = 100, name = "USERNAME")
    private String username;

    @SQLDate(name = "UPDATE_DATE")
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
