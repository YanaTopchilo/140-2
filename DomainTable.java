/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxexample2;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Topchilo
 */
public class DomainTable {
    private String webname;
    private String domainName;
    private String IP;
    private Date dateReg;
    private String country;


    public DomainTable(String webname, String domainName, String IP, Date dateReg, String country) {
        this.webname = webname;
        this.domainName = domainName;
        this.IP = IP;
        this.dateReg = dateReg;
        this.country = country;
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
 
    
    @Override
    public String toString() {
        return "Domain{" +  ", webname=" + webname + ", domainName=" + domainName 
                + ", IP=" + IP + ", dateReg=" + dateReg + ", country=" + country   +'}';
    }
    
}
