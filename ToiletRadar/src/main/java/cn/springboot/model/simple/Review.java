package cn.springboot.model.simple;

import java.util.Date;

public class Review {
    private Long pkId;

    private String content;

    private Byte score;

    private Date createTime;

    private Date modifyTime;

    private Boolean deleteStatus;

    private Integer likeCount;

    private String frToilet;

    private String frAccount;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getScore() {
        return score;
    }

    public void setScore(Byte score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getFrToilet() {
        return frToilet;
    }

    public void setFrToilet(String frToilet) {
        this.frToilet = frToilet;
    }

    public String getFrAccount() {
        return frAccount;
    }

    public void setFrAccount(String frAccount) {
        this.frAccount = frAccount;
    }
}