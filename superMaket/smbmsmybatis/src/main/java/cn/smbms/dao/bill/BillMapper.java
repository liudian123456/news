package cn.smbms.dao.bill;

import cn.smbms.entity.Bill;
import cn.smbms.entity.Provider;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public interface BillMapper {
 List<Bill> getProductNameByName(Map map);
 List<Bill> getBillProviserIdByName(Map map);//模糊查询
 //    嵌套association查询
 List<Bill> getBillAssociation(Bill bill);
// colltetion
List<Bill> getBillColltetionByProviderId(Integer id);
List<Bill> getBillList_chooose(
        @Param("billCode") String billCode,
        @Param("productName") String productName,
        @Param("creationDate") Data creationDate,
        @Param("id") Integer id

);
}
