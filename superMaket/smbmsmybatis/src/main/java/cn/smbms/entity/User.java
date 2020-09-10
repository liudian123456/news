package cn.smbms.entity;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {
   private  Integer id;
    private String   userCode;
    private String userName;
    private    String    userPassword;
    private  Integer gender;
    private Date birthday;
    private String phone;
    private    String   address;
    private Integer userRole;
    private   Integer  createdBy;
    private Date creationDate;
    private  Integer    modifyBy;
    private Date  modifyDate;
    /*角色*/
 private String userRoleName;

}
