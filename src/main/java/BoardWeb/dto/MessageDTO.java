package BoardWeb.dto;

import BoardWeb.repository.UserMapper;
import BoardWeb.service.UserService;

import java.sql.Timestamp;

public class MsgDTO {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom_account() {
        return from_account;
    }

    public void setFrom_account(String from_account) {
        this.from_account = from_account;
    }

    public String getTo_account() {
        return to_account;
    }

    public void setTo_account(String to_account) {
        this.to_account = to_account;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    protected String from_account;
    protected String to_account;
    protected String content;
    protected Timestamp sent_at;

    public Timestamp getSent_at() {
        return sent_at;
    }

    public void setSent_at(Timestamp sent_at) {
        this.sent_at = sent_at;
    }
}