package com.cdc.ecommerce.model;

import java.util.Date;

public class Account {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.pk_id
     *
     * @mbg.generated
     */
    private Long pkId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.wx_photo
     *
     * @mbg.generated
     */
    private String wxPhoto;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.wx_name
     *
     * @mbg.generated
     */
    private String wxName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.identity
     *
     * @mbg.generated
     */
    private String identity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.delete_status
     *
     * @mbg.generated
     */
    private Boolean deleteStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.modify_time
     *
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.pk_id
     *
     * @return the value of account.pk_id
     *
     * @mbg.generated
     */
    public Long getPkId() {
        return pkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.pk_id
     *
     * @param pkId the value for account.pk_id
     *
     * @mbg.generated
     */
    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.wx_photo
     *
     * @return the value of account.wx_photo
     *
     * @mbg.generated
     */
    public String getWxPhoto() {
        return wxPhoto;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.wx_photo
     *
     * @param wxPhoto the value for account.wx_photo
     *
     * @mbg.generated
     */
    public void setWxPhoto(String wxPhoto) {
        this.wxPhoto = wxPhoto == null ? null : wxPhoto.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.wx_name
     *
     * @return the value of account.wx_name
     *
     * @mbg.generated
     */
    public String getWxName() {
        return wxName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.wx_name
     *
     * @param wxName the value for account.wx_name
     *
     * @mbg.generated
     */
    public void setWxName(String wxName) {
        this.wxName = wxName == null ? null : wxName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.password
     *
     * @return the value of account.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.password
     *
     * @param password the value for account.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.identity
     *
     * @return the value of account.identity
     *
     * @mbg.generated
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.identity
     *
     * @param identity the value for account.identity
     *
     * @mbg.generated
     */
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.delete_status
     *
     * @return the value of account.delete_status
     *
     * @mbg.generated
     */
    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.delete_status
     *
     * @param deleteStatus the value for account.delete_status
     *
     * @mbg.generated
     */
    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.create_time
     *
     * @return the value of account.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.create_time
     *
     * @param createTime the value for account.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.modify_time
     *
     * @return the value of account.modify_time
     *
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.modify_time
     *
     * @param modifyTime the value for account.modify_time
     *
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}