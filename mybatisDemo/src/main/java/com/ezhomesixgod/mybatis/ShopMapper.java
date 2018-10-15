package com.ezhomesixgod.mybatis;

import com.ezhomesixgod.bean.Shop;

public interface ShopMapper {

    Shop selectOneById(Integer id);
}
