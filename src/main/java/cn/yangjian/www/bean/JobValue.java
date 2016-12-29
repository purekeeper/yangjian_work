package cn.yangjian.www.bean;

/**
 * Created by yangjian on 16-12-21.
 */

import java.io.Serializable;

/**
 * Created by yangjian on 16-12-12.
 */
public class JobValue implements Serializable {
    private int jobBizId;
    private String jobEntityId;
    private long executeTime;

    public JobValue() {
    }

    public JobValue(int jobBizId, String jobEntityId, long executeTime) {
        this.jobBizId = jobBizId;
        this.jobEntityId = jobEntityId;
        this.executeTime = executeTime;
    }

    public int getJobBizId() {
        return jobBizId;
    }

    public void setJobBizId(int jobBizId) {
        this.jobBizId = jobBizId;
    }

    public String getJobEntityId() {
        return this.jobEntityId;
    }

    public void setJobEntityId(String jobEntityId) {
        this.jobEntityId = jobEntityId;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    @Override
    public String toString() {
        return "JobValue{" +
                "executeTime=" + executeTime +
                ", jobBizId=" + jobBizId +
                ", JobEntityId='" + jobEntityId + '\'' +
                '}';
    }
}
