package cn.yangjian.www.hibernatebean;

/**
 * Created by yangjian on 16-12-30.
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "comm", catalog = "yangjian")
public class Comm implements Serializable {
    private long id;
    private Date buildYear;
    private String commName;
    private String commAddr;

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "build_year", length = 4)
    public Date getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(Date buildYear) {
        this.buildYear = buildYear;
    }


    @Column(name = "comm_name", length = 50)
    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    @Column(name = "comm_addr", length = 100)
    public String getCommAddr() {
        return commAddr;
    }

    public void setCommAddr(String commAddr) {
        this.commAddr = commAddr;
    }
}
