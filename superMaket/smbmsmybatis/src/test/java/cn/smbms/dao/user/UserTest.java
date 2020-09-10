package cn.smbms.dao.user;




import cn.smbms.entity.User;
import cn.smbms.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UserTest {
    Logger logger=Logger.getLogger(UserTest.class);
    @Test
    public  void test01() throws IOException {
        InputStream is=null;
        is= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession=sessionFactory.openSession();
        int count=sqlSession.selectOne("cn.smbms.dao.user.UserMapper.count");
        logger.info("用户表数量：" +count);
    }

    @Test//getUserList
    public  void test04()  {
       SqlSession sqlSession=null;
       List<User> userList=null;
        try {
            sqlSession= MybatisUtil.openSqlSession();
         Map<String,Object> map=new HashMap<>();
            map.put("userName","孙");
//            map.put("userRole","3");
            userList=sqlSession.getMapper(UserMapper.class).getUserList(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

        logger.info(userList);


    }
    @Test
    public  void test05()  {
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession= MybatisUtil.openSqlSession();
             count=sqlSession.getMapper(UserMapper.class).count();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        logger.info(count);
    }
    @Test
    public  void test06()  {
        SqlSession sqlSession=null;
        List<User> userList=null;
        try {
            sqlSession= MybatisUtil.openSqlSession();
            userList=sqlSession.getMapper(UserMapper.class).getUserByName("孙");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

        logger.info(userList);


    }
    @Test
    public  void test07()  {
        SqlSession sqlSession=null;
        List<User> userList=null;
        try {
            sqlSession= MybatisUtil.openSqlSession();
            User user=new User();
            user.setUserName("孙");
            userList=sqlSession.getMapper(UserMapper.class).getUserByName("孙");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

        logger.info(userList);


    }
    @Test
    public  void test08()  {
        SqlSession sqlSession=null;
        List<User> userList=null;
        try {
        sqlSession= MybatisUtil.openSqlSession();
            Map<String,Object> map=new HashMap<>();
            map.put("userName","孙");
            map.put("userRole","3");
             userList=sqlSession.getMapper(UserMapper.class).getUserListConditionMap(map);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

        logger.info(userList);


    }
    @Test/*修改*/
    public  void test09()  {
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession= MybatisUtil.openSqlSession();
           User user=new User();
           user.setUserName("小昭");
           user.setId(15);
            count=sqlSession.getMapper(UserMapper.class).update(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

        logger.info(count);


    }
    @Test/* 修改222*/
    public  void test10()  {
        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession= MybatisUtil.openSqlSession();
            count=sqlSession.getMapper(UserMapper.class).updatePassword(14,"654321");
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        logger.info(count);
    }
    @Test/* foreach-array*/
    public  void test11()  {
        SqlSession sqlSession=null;
       List<User> userList=new ArrayList<>();
       User user=new User();
        try {
            sqlSession= MybatisUtil.openSqlSession();
            userList=sqlSession.getMapper(UserMapper.class).getUserList_foreach_array(new Integer[]{1,2,3});
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        logger.info(userList);
    }
    @Test/* foreach-list*/
    public  void test12()  {
        SqlSession sqlSession=null;
        List list=new ArrayList<>();
        try {
            sqlSession= MybatisUtil.openSqlSession();
            list.add(1);
            list.add(2);

            List list1 = sqlSession.getMapper(UserMapper.class).getUserList_foreach_list(list);
            logger.info(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

    } @Test/* choose*/
    public  void test13()  {
        SqlSession sqlSession=null;
        try {
            sqlSession= MybatisUtil.openSqlSession();

            List list1 = sqlSession.getMapper(UserMapper.class).getUserLiset_choose(null,null,null,new Date());
            logger.info(list1);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }

    }

}
