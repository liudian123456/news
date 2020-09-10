package cn.smbms.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@lombok.Data
public class Provider implements Serializable {
  private  Integer id;
    private String       proCode;
    private String proName;
    private  String     proDesc;
    private String proContact;
    private   String      proPhone;
    private String proAddress;
    private  String      proFax;;
    private Integer createdBy;
    private Date creationDate;
    private Date  modifyDate;
    private  Integer      modifyBy;
//


}
