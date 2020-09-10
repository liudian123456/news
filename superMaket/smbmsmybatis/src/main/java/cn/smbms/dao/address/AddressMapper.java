package cn.smbms.dao.address;

import cn.smbms.entity.Address;

import java.util.List;
import java.util.Map;

public interface AddressMapper {
    List<Address> queryAllAddress();
    int add(Address address);
    int update(Address address);
}
