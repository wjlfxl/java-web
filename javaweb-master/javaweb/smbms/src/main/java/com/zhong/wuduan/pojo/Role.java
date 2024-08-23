package com.zhong.wuduan.pojo;


import java.util.Date;
import java.util.Objects;

/**
 * @author wuduan
 * @version 1.8
 * @date 2022/2/20 18:10
 */
public class Role {
    private Integer id;//ID
    private String roleCode;//角色编码
    private String roleName;//角色名称
    private Integer createdBy;//创建者
    private Date creationDate;//创建时间
    private Integer modifyBy;//更新者
    private Date modifyDate;//更新时间

    public Role() {
    }

    public Role(Integer id, String roleCode, String roleName, Integer createdBy, Date creationDate, Integer modifyBy, Date modifyDate) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(roleCode, role.roleCode) && Objects.equals(roleName, role.roleName) && Objects.equals(createdBy, role.createdBy) && Objects.equals(creationDate, role.creationDate) && Objects.equals(modifyBy, role.modifyBy) && Objects.equals(modifyDate, role.modifyDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleCode, roleName, createdBy, creationDate, modifyBy, modifyDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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
}
