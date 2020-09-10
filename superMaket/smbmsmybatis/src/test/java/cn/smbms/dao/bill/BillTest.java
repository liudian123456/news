package cn.smbms.dao.bill;



import cn.smbms.entity.Bill;
import cn.smbms.entity.Provider;
import cn.smbms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillTest {
    Logger logger=Logger.getLogger(BillTest.class);
    @Test
    public  void test04()  {
        SqlSession sqlSession=null;
        List<Bill> billList=new ArrayList<>();
        try {
            sqlSession= MybatisUtil.openSqlSession();
            Map<String,Object> map=new HashMap<>();
            map.put("productName","油");
            map.put("isPayment","3");
            map.put("providerId","14");
            billList=sqlSession.getMapper(BillMapper.class).getProductNameByName(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

//        logger.info(billList);
        for (Bill bill:billList
             ) {
//            System.out.println(bill);
            logger.info(bill);

        }

    }

    @Test
    public  void test02()  {
        SqlSession sqlSession=null;
        List<Bill> billList=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        try {
            sqlSession = MybatisUtil.openSqlSession();

//            map.put("productName","油");
            map.put("isPayment",2);
            map.put("from",2);
            map.put("pageSize",2);
            billList = sqlSession.getMapper(BillMapper.class).getBillProviserIdByName(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }
    @Test//
    public  void test03()  {
        SqlSession sqlSession=null;
      List<Bill> billList=new ArrayList();
        try {
            sqlSession = MybatisUtil.openSqlSession();
            Bill bill=new Bill();
            bill.setProviderId(14);
            billList = sqlSession.getMapper(BillMapper.class).getBillAssociation(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        for (Bill bill : billList) {
            System.out.println(bill);
        }

    }
    @Test//collection
    public  void test05()  {
        SqlSession sqlSession=null;
        List<Bill> billList=new ArrayList();
//        Bill bill=new Bill();
        try {
            sqlSession = MybatisUtil.openSqlSession();

//            bill.setProviderId(14);
            billList= sqlSession.getMapper(BillMapper.class).getBillColltetionByProviderId(14);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

        for (Bill bill:billList) {
            System.out.println(bill);
        }

    }
    @Test//choose
    public  void test06()  {
        SqlSession sqlSession=null;
        List<Bill> billList=new ArrayList();
//        Bill bill=new Bill();
        try {
            sqlSession = MybatisUtil.openSqlSession();

//            bill.setProviderId(14);
            billList= sqlSession.getMapper(BillMapper.class).getBillList_chooose(null,null,null,1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

        for (Bill bill:billList) {
            System.out.println(bill);
        }

    }
}
