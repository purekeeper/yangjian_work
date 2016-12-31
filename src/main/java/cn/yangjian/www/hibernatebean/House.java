package cn.yangjian.www.hibernatebean;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by yangjian on 16-12-30.
 */
@Entity
@Table(name = "house", catalog = "yangjian",
        indexes = {
                @Index(name = "idx_area", columnList = "area"),
                @Index(name = "idx_rooms", columnList = "rooms"),
                @Index(name = "idx_price", columnList = "price"),
                @Index(name = "idx_publish_time", columnList = "publish_time")
        })
public class House implements Serializable {
    private long id;
    private String title;
    private int area;
    private int rooms;
    private int halls;
    private int price;
    private int floor;
    private int totalFloor;
    private User user;
    private Timestamp publishTime;


    @OneToOne
    @JoinColumn(name = "broker_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title", length = 31)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "area")
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Column(name = "rooms")
    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Column(name = "halls")
    public int getHalls() {
        return halls;
    }

    public void setHalls(int halls) {
        this.halls = halls;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "floor")
    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Column(name = "total_floor")
    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    @Column(name = "publish_time")
    public Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }
}
