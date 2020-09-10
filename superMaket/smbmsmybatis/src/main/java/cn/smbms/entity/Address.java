package cn.smbms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Address implements Serializable {
  private  Integer id;
    private  String     contact;
    private String addressDesc;
    private   String      postCode;
    private String  tel;
    private    Integer   createdBy;
    private Date creationDate;
    private  Integer      modifyBy;
    private Date  modifyDate;
    private    Integer     userId;
    /*用户姓名*/
  private String userName ;


}
