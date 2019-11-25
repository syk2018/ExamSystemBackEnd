package com.syk.exam.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TbSturesult implements Serializable {
    private Long id;

    private String stuid;

    private String whichlesson;

    private Date examtime;

    private Integer examid;

    private String quesid;

    private String answer;

    private Integer restotal;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getWhichlesson() {
        return whichlesson;
    }

    public void setWhichlesson(String whichlesson) {
        this.whichlesson = whichlesson;
    }

    public Date getExamtime() {
        return examtime;
    }

    public void setExamtime(Date examtime) {
        this.examtime = examtime;
    }

    public Integer getExamid() {
        return examid;
    }

    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    public String getQuesid() {
        return quesid;
    }

    public void setQuesid(String quesid) {
        this.quesid = quesid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getRestotal() {
        return restotal;
    }

    public void setRestotal(Integer restotal) {
        this.restotal = restotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", stuid=").append(stuid);
        sb.append(", whichlesson=").append(whichlesson);
        sb.append(", examtime=").append(examtime);
        sb.append(", examid=").append(examid);
        sb.append(", quesid=").append(quesid);
        sb.append(", answer=").append(answer);
        sb.append(", restotal=").append(restotal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}