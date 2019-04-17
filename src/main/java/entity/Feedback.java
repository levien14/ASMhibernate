package entity;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue
    private int feedbackid;

    @ManyToOne
    @JoinColumn(name = "accountid")
    private Account accountfeeadback;
    private String content;
    private int status;

    public Feedback() {
    }

    public Feedback(Account accountfeeadback, String content) {
       this.accountfeeadback = accountfeeadback;
        this.content = content;
    }

    public Feedback(Account accountfeeadback, String content, int status) {
        this.accountfeeadback = accountfeeadback;
        this.content = content;
        this.status = status;
    }

    public int getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(int feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Account getAccountfeeadback() {
        return accountfeeadback;
    }

    public void setAccountfeeadback(Account accountfeeadback) {
        this.accountfeeadback = accountfeeadback;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
