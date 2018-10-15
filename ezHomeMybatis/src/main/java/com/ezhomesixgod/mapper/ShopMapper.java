package com.ezhomesixgod.mapper;

import com.ezhomesixgod.annotation.EzHomeParam;
import com.ezhomesixgod.entity.Shop;

public interface ShopMapper {

    Shop findShopById(@EzHomeParam("id") Integer id);
}
