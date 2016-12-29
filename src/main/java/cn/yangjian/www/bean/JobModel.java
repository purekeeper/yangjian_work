package cn.yangjian.www.bean;

import java.io.Serializable;

/**
 * Created by yangjian on 16-10-25.
 */
/*
一个具体的计划任务
 */
public class JobModel implements Serializable, Comparable<JobModel> {//待确定
    private String jobId;
    private long executeTime;
    private JobState jobState;
    private int jobBizId;
    private String JobEntityId;

    public JobModel(int jobBizId, String jobEntityId, long executeTime, JobState jobState) {
        this.executeTime = executeTime;
        this.jobState = jobState;
        this.jobBizId = jobBizId;
        this.JobEntityId = jobEntityId;
        this.jobId = String.valueOf(jobBizId) + "_" + jobEntityId + "_" + String.valueOf(executeTime);
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public JobState getJobState() {
        return jobState;
    }

    public void setJobState(JobState jobState) {
        this.jobState = jobState;
    }

    public int getJobBizId() {
        return jobBizId;
    }

    public void setJobBizId(int jobBizId) {
        this.jobBizId = jobBizId;
    }

    public String getJobEntityId() {
        return JobEntityId;
    }

    public void setJobEntityId(String jobEntityId) {
        JobEntityId = jobEntityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobModel jobModel = (JobModel) o;

        return jobId.equals(jobModel.getJobId());

    }

    @Override
    public int hashCode() {

        return jobId.hashCode();
    }

    @Override
    public int compareTo(JobModel o) {
        return this.executeTime - o.getExecuteTime() > 0 ? 1 : -1;
    }

    /**
     * run 待执行
     * running 执行中
     * runned 已执行
     */
    public enum JobState {
        run(-1, "待运行"),
        running(0, "运行中"),
        runed(1, "已运行");
        private int stateCode;
        private String desc;

        JobState(int stateCode, String desc) {
            this.stateCode = stateCode;
            this.desc = desc;
        }

        public int getStateCode() {
            return stateCode;
        }

        public String getDesc() {
            return desc;
        }

        public static JobState getState(int stateCode) {
            for (JobState jobState : values()) {
                if (stateCode == jobState.getStateCode()) {
                    return jobState;
                }
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "JobModel{" +
                "jobId='" + jobId + '\'' +
                ", executeTime=" + executeTime +
                ", jobState=" + jobState +
                ", jobBizId=" + jobBizId +
                ", JobEntityId='" + JobEntityId + '\'' +
                '}';
    }
}
