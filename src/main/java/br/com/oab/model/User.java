package br.com.oab.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    private String password;

    private String userId;

    private String userName;

    private Long createdBy;

    private Date createdOn;

    private Long updatedBy;

    private Date updatedOn;

    private Long updatedByInterface;

    private Date updatedOnInterface;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getUpdatedByInterface() {
        return updatedByInterface;
    }

    public void setUpdatedByInterface(Long updatedByInterface) {
        this.updatedByInterface = updatedByInterface;
    }

    public Date getUpdatedOnInterface() {
        return updatedOnInterface;
    }

    public void setUpdatedOnInterface(Date updatedOnInterface) {
        this.updatedOnInterface = updatedOnInterface;
    }

	@Override
	public String toString() {
		return "User {id=" + id + ", password=" + password + ", userId=" + 
	userId + ", userName=" + userName
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", "
						+ "updatedBy=" + updatedBy + ", updatedOn="
				+ updatedOn + ", updatedByInterface=" + 
						updatedByInterface + ", updatedOnInterface="
				+ updatedOnInterface + "}";
	}
    
    
    
}
