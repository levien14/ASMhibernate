package entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Userinformation")
public class Userinformation {
    @Id
    @Column(name = "userid")
    private int userid;


    //@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false) //cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountid",referencedColumnName = "accountid")
    private Account account;

    @Column(name = "username")

    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "address")
    private String address;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "phone")
    private String phone;


    public Userinformation(Account account, String username, String fullname, String address, Date dob, String phone) {
        this.account = account;
        this.username = username;
        this.fullname = fullname;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
    }

    public Userinformation() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
