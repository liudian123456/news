package cn.smbms.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Bill implements Serializable {
  private Integer  id;
    private String     billCode;
    private String productName;
    private  String       productDesc;
    private String  productUnit;
    private   Float     productCount;
    private Float  totalPrice;
    private    Integer   isPayment;;
    private Integer createdBy;
    private Date creationDate;
    private Integer  modifyBy;
    private  Date      modifyDate;
    private Integer providerId;
    /**/
//    private String providerName;
//    private Provider provider;
    private List<Provider> providerList;
}
