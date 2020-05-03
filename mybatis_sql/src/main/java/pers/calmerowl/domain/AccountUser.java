package pers.calmerowl.domain;

import java.io.Serializable;

/**
 * @author: calmerowl
 * @date: 2020/5/2 22:08
 * @version: 1.0.0
 */
public class AccountUser implements Serializable {

    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+"        AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
