package cn.yangjian.www.bean;

/**
 * Created by yangjian on 16-12-22.
 * 统计各机器任务负载情况
 */
public class MachineLoadInfo {
    //no ip:port slices taskqueue schedule jobs
    private String address;//地址
    private int no;//编号
    private int sliceInfo;//分片
    private int taskQueueEntityCount;//实体个数
    private int scheduleCount;
    private int taskQueuetotalJobs;
    private int wlistTotalJobs;

    public MachineLoadInfo() {
    }

    public MachineLoadInfo(String address, int no, int sliceInfo, int taskQueueEntityCount, int scheduleCount, int taskQueuetotalJobs, int wlistTotalJobs) {
        this.address = address;
        this.no = no;
        this.sliceInfo = sliceInfo;
        this.taskQueueEntityCount = taskQueueEntityCount;
        this.scheduleCount = scheduleCount;
        this.taskQueuetotalJobs = taskQueuetotalJobs;
        this.wlistTotalJobs = wlistTotalJobs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getSliceInfo() {
        return sliceInfo;
    }

    public void setSliceInfo(int sliceInfo) {
        this.sliceInfo = sliceInfo;
    }

    public int getTaskQueueEntityCount() {
        return taskQueueEntityCount;
    }

    public void setTaskQueueEntityCount(int taskQueueEntityCount) {
        this.taskQueueEntityCount = taskQueueEntityCount;
    }

    public int getScheduleCount() {
        return scheduleCount;
    }

    public void setScheduleCount(int scheduleCount) {
        this.scheduleCount = scheduleCount;
    }

    public int getTaskQueuetotalJobs() {
        return taskQueuetotalJobs;
    }

    public void setTaskQueuetotalJobs(int taskQueuetotalJobs) {
        this.taskQueuetotalJobs = taskQueuetotalJobs;
    }

    public int getWlistTotalJobs() {
        return wlistTotalJobs;
    }

    public void setWlistTotalJobs(int wlistTotalJobs) {
        this.wlistTotalJobs = wlistTotalJobs;
    }
}
