package cn.yangjian.www.hibernatebean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yangjian on 16-12-30.
 */
@Entity
@Table(name = "broker", catalog = "yangjian",
        indexes = {
                @Index(name = "idx_account", columnList = "account"),
                @Index(name = "idx_pwd", columnList = "pwd")
        })
public class User implements Serializable {
    private long id;
    private String name;
    private String account;
    private String pwd;
    private boolean isBroker;

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", length = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "account", length = 15)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "pwd", length = 15)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "is_broker")
    public boolean isBroker() {
        return isBroker;
    }

    public void setBroker(boolean broker) {
        isBroker = broker;
    }
}
