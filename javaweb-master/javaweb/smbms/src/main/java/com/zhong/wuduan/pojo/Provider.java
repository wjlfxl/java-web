package com.zhong.wuduan.pojo;

import java.util.Date;
import java.util.Objects;
import java.util.zip.DataFormatException;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/19 18:00
 */
public class Provider {
    private Integer id;//id
    private String proCode;//供应商编码
    private String proName;//供应商名称
    private String proDesc;//供应商描述
    private String proContact;//供应商联系人
    private String proPhone;//供应商电话
    private String proAddress;//供应商地址
    private String proFax;//供应商传真
    private Integer createBy;
    private Date creationDate; 
    private Integer modifyBy;
    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public String getProContact() {
        return proContact;
    }

    public void setProContact(String proContact) {
        this.proContact = proContact;
    }

    public String getProPhone() {
        return proPhone;
    }

    public void setProPhone(String proPhone) {
        this.proPhone = proPhone;
    }

    public String getProAddress() {
        return proAddress;
    }

    public void setProAddress(String proAddress) {
        this.proAddress = proAddress;
    }

    public String getProFax() {
        return proFax;
    }

    public void setProFax(String proFax) {
        this.proFax = proFax;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provider provider = (Provider) o;
        return Objects.equals(id, provider.id) && Objects.equals(proCode, provider.proCode) && Objects.equals(proName, provider.proName) && Objects.equals(proDesc, provider.proDesc) && Objects.equals(proContact, provider.proContact) && Objects.equals(proPhone, provider.proPhone) && Objects.equals(proAddress, provider.proAddress) && Objects.equals(proFax, provider.proFax) && Objects.equals(createBy, provider.createBy) && Objects.equals(creationDate, provider.creationDate) && Objects.equals(modifyBy, provider.modifyBy) && Objects.equals(modifyDate, provider.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createBy, creationDate, modifyBy, modifyDate);
    }

    public Provider(Integer id, String proCode, String proName, String proDesc, String proContact, String proPhone, String proAddress, String proFax, Integer createBy, Date creationDate, Integer modifyBy, Date modifyDate) {
        this.id = id;
        this.proCode = proCode;
        this.proName = proName;
        this.proDesc = proDesc;
        this.proContact = proContact;
        this.proPhone = proPhone;
        this.proAddress = proAddress;
        this.proFax = proFax;
        this.createBy = createBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    public Provider() {
    }
}
