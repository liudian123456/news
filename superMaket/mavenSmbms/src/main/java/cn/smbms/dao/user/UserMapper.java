package cn.smbms.dao.user;

import cn.smbms.pojo.User;


public interface UserMapper {
    /**
     * 通过userCode获取User
     * @param userCode
     * @return
     */
   User getLoginUser(String userCode);

}
