package br.com.oab.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="LoginUsers")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Password",length = 10)
    private String password;

    @Column(name = "UserID",length = 20)
    private String userId;

    @Column(name = "UserName",length = 100)
    private String userName;

    @Column(name = "CreatedBy")
    private Long createdBy;

    @Column(name = "CreatedOn",length = 200)
    private Date createdOn;

    @Column(name = "UpdatedBy")
    private Long updatedBy;

    @Column(name = "UpdatedOn",length = 200)
    private Date updatedOn;

    @Column(name = "UpdatedByInterface")
    private Long updatedByInterface;

    @Column(name = "UpdatedOnInterface")
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
}
