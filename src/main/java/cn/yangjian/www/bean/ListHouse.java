package cn.yangjian.www.bean;

/**
 * Created by yangjian on 16-12-31.
 */
public class ListHouse {
    private String title;
    private int area;
    private int rooms;
    private int halls;
    private int price;
    private int floor;
    private int totalFloor;
    private String publiser;
    private String url;

    public ListHouse(String title, int area, int rooms, int halls, int price, int floor, int totalFloor, String publiser) {
        this.title = title;
        this.area = area;
        this.rooms = rooms;
        this.halls = halls;
        this.price = price;
        this.floor = floor;
        this.totalFloor = totalFloor;
        this.publiser = publiser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getHalls() {
        return halls;
    }

    public void setHalls(int halls) {
        this.halls = halls;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    public String getPubliser() {
        return publiser;
    }

    public void setPubliser(String publiser) {
        this.publiser = publiser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
