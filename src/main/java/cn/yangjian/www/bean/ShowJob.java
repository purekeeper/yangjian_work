package cn.yangjian.www.bean;

import java.io.Serializable;

/**
 * Created by yangjian on 16-12-28.
 */
public class ShowJob implements Serializable{
    private String no;
    private long executeTime;
    private String jobState;
    private int jobBizId;
    private String jobBizDesc;
    private String jobEntityId;
    private String deleteUrl;
    private String editUrl;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public String getJobState() {
        return jobState;
    }

    public void setJobState(String jobState) {
        this.jobState = jobState;
    }

    public int getJobBizId() {
        return jobBizId;
    }

    public void setJobBizId(int jobBizId) {
        this.jobBizId = jobBizId;
    }

    public String getJobBizDesc() {
        return jobBizDesc;
    }

    public void setJobBizDesc(String jobBizDesc) {
        this.jobBizDesc = jobBizDesc;
    }

    public String getJobEntityId() {
        return jobEntityId;
    }

    public void setJobEntityId(String jobEntityId) {
        this.jobEntityId = jobEntityId;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    @Override
    public String toString() {
        return "ShowJob{" +
                "no='" + no + '\'' +
                ", executeTime=" + executeTime +
                ", jobState='" + jobState + '\'' +
                ", jobBizId=" + jobBizId +
                ", jobBizDesc='" + jobBizDesc + '\'' +
                ", jobEntityId='" + jobEntityId + '\'' +
                ", deleteUrl='" + deleteUrl + '\'' +
                ", editUrl='" + editUrl + '\'' +
                '}';
    }
}