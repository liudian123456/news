package cn.smbms.dao.user;

import cn.smbms.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    int count();
    List<User> getUserList(Map map);
    List<User> getUserByName(String userName);
    List<User> getUserListCondition(User user);
    List<User> getUserListConditionMap(Map map);
int update(User user);
int add(User user);
/*修改@param*/
    int  updatePassword(
           @Param("id") Integer id,
           @Param("userPassword") String passsword
    );
    List<User> getUserList_foreach_array(Integer[] roleId);
    List<User> getUserList_foreach_list(List<Integer> list);
    List<User> getUserLiset_choose(
            @Param("userCode") String userCode,
            @Param("userName") String userName,
            @Param("userRole") Integer userRole,
            @Param("creationDate") Date creationDate
    );
}
