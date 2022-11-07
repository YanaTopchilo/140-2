/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxexample2;

import java.sql.Date;

/**
 *
 * @author Topchilo
 */
public class Domain {
    private Integer id;
    private String webname;
    private String domainName;
    private String IP;
    private Date dateReg;
    private String country;
    private Person person;

    public Domain(Integer id, String webname, String domainName, String IP, Date dateReg, String country, Person person) {
        this.id = id;
        this.webname = webname;
        this.domainName = domainName;
        this.IP = IP;
        this.dateReg = dateReg;
        this.country = country;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
    @Override
    public String toString() {
        return "Domain{" + "id=" + id + ", webname=" + webname + ", domainName=" + domainName 
                + ", IP=" + IP + ", dateReg=" + dateReg + ", country=" + country +", person= " + person  +'}';
    }
}
