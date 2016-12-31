package cn.yangjian.www.hibernatebean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yangjian on 16-12-30.
 */
@Entity
@Table(name = "house_ext", catalog = "yangjian")
public class HouseExt implements Serializable {
    private long id;
    private String houseDesc;
    private Comm comm;
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "house_dec", length = 5000)
    public String getHouseDesc() {
        return houseDesc;
    }

    public void setHouseDesc(String houseDesc) {
        this.houseDesc = houseDesc;
    }

    @OneToOne
    @JoinColumn(name = "comm_id")
    public Comm getComm() {
        return comm;
    }

    public void setComm(Comm comm) {
        this.comm = comm;
    }
}
