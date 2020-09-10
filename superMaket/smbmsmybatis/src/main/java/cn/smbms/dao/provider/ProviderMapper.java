package cn.smbms.dao.provider;

import cn.smbms.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {
    int count();
    List<Provider> getProviderList();
//    删除
    int deleteProviderById(@Param("id") Integer id);

}
