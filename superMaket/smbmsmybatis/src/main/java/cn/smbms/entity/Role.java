package cn.smbms.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@lombok.Data
public class Role implements Serializable {
  private  Integer id;
    private  String      roleCode;
    private String roleName;
    private     Integer    createdBy;
    private Date creationDate;
    private  Integer       modifyBy;
    private Date modifyDate;

}
