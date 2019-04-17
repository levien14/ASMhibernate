package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "accountid")
    @GeneratedValue
    private int accountid;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private int status;



    @OneToMany(mappedBy = "accountfeeadback", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Feedback> feedbackList = new ArrayList<Feedback>();


    public Account() {
    }



    public Account(String email, String password) {
        this.accountid = accountid;
        this.email = email;
        this.password = password;
    }

    public Account(String email, String password, int status) {
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }
}


