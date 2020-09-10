package cn.smbms.dao.provider;

import cn.smbms.dao.user.UserTest;
import cn.smbms.entity.Provider;
import cn.smbms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class ProviderTest {
    Logger logger=Logger.getLogger(UserTest.class);
    @Test
    public  void test02() throws IOException {

        SqlSession sqlSession=null;
        List<Provider> providers=null;
        try {
            sqlSession= MybatisUtil.openSqlSession();
            providers=sqlSession.getMapper(ProviderMapper.class).getProviderList();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        for (Provider provider:providers
        ) {
            logger.info(provider);
        }


    }
    @Test
    public  void test021()  {

        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession= MybatisUtil.openSqlSession();
            count=sqlSession.getMapper(ProviderMapper.class).count();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        logger.info(count);
    }
    @Test/*删除*/
    public  void test011()  {

        SqlSession sqlSession=null;
        int count=0;
        try {
            sqlSession= MybatisUtil.openSqlSession();
            count=sqlSession.getMapper(ProviderMapper.class).deleteProviderById(15);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSqlSession(sqlSession);
        }
        logger.info(count);
    }

}
