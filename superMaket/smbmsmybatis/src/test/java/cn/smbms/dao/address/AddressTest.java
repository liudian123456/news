package cn.smbms.dao.address;

import cn.smbms.dao.bill.BillTest;
import cn.smbms.entity.Address;
import cn.smbms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;

public class AddressTest {
    Logger logger=Logger.getLogger(AddressTest.class);
    @Test/*查询*/
    public void test1(){
        SqlSession sqlSession=null;
        List<Address> addressList=new ArrayList<>();
        try {
            sqlSession= MybatisUtil.openSqlSession();
//            Map map=new HashMap();
//            map.put()
            addressList=sqlSession.getMapper(AddressMapper.class).queryAllAddress();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        for (Address address:addressList) {
            logger.info(address);
        }

    }
    @Test/*添加*/
    public void test2(){
        SqlSession sqlSession=null;
        int count =0;
        try {
            sqlSession= MybatisUtil.openSqlSession();
            Address address=new Address();
            address.setContact("contact");
            address.setAddressDesc("addressDesc");
            address.setPostCode("postCode");
            address.setTel("tel");
            address.setCreatedBy(1);
            address.setCreationDate(new Date());
            address.setId(1);
            count=sqlSession.getMapper(AddressMapper.class).add(address);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {

            MybatisUtil.closeSqlSession(sqlSession);
        }
        logger.info(count);

    }
    @Test/*222222222修改*/
    public  void test3(){
        SqlSession sqlSession=null;
        Address address=new Address();
        int count=0;
        try {
            sqlSession=MybatisUtil.openSqlSession();
            address.setId(8);
            address.setContact("小二郎儿11");
//            address.setAddressDesc("北京市海淀区丹棱街3号");
            count=sqlSession.getMapper(AddressMapper.class).update(address);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
           MybatisUtil.closeSqlSession(sqlSession);
        }
    }
}
