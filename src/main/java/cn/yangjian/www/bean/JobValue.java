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
    private String jobState;

    public JobValue() {
    }

    public JobValue(int jobBizId, String jobEntityId, long executeTime, String jobState) {
        this.jobBizId = jobBizId;
        this.jobEntityId = jobEntityId;
        this.executeTime = executeTime;
        this.jobState = jobState;
    }

    public void setJobBizId(int jobBizId) {
        this.jobBizId = jobBizId;
    }

    public void setJobEntityId(String jobEntityId) {
        this.jobEntityId = jobEntityId;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public int getJobBizId() {
        return jobBizId;
    }

    public String getJobEntityId() {
        return this.jobEntityId;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public String getJobState() {
        return jobState;
    }
}

