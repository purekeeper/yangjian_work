package cn.yangjian.www.bean;

/**
 * Created by yangjian on 16-12-22.
 * 统计各机器任务负载情况
 */
public class MachineLoadInfo {
    //no ip:port slices taskqueue schedule jobs
    private String address;
    private int no;
    private int sliceInfo;
    private int taskQueueInfo;
    private int scheduleInfo;
    private int totalJobs;

    public MachineLoadInfo(String address, int no, int sliceInfo, int taskQueueInfo, int scheduleInfo, int totalJobs) {
        this.address = address;
        this.no = no;
        this.sliceInfo = sliceInfo;
        this.taskQueueInfo = taskQueueInfo;
        this.scheduleInfo = scheduleInfo;
        this.totalJobs = totalJobs;
    }

    public MachineLoadInfo() {
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

    public int getTaskQueueInfo() {
        return taskQueueInfo;
    }

    public void setTaskQueueInfo(int taskQueueInfo) {
        this.taskQueueInfo = taskQueueInfo;
    }

    public int getScheduleInfo() {
        return scheduleInfo;
    }

    public void setScheduleInfo(int scheduleInfo) {
        this.scheduleInfo = scheduleInfo;
    }

    public int getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(int totalJobs) {
        this.totalJobs = totalJobs;
    }
}
