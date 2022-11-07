/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxexample2;

import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author Topchilo
 */
class Person {
    private Integer id;
    private String jobtitle;
    private String fullname;
    private String phone;
    private String email;

    public Person(Integer id, String jobtitle, String fullname, String phone, String email) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  
    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", jobtitle=" + jobtitle + ", fullname=" + fullname + ", phone=" + phone + ", email=" + email + '}';
    }
}
