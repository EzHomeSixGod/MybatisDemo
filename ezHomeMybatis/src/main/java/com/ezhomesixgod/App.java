package com.ezhomesixgod;

import com.ezhomesixgod.dao.DefaultEzHomeSqlSession;
import com.ezhomesixgod.dao.EzHomeSqlSession;
import com.ezhomesixgod.entity.Shop;
import com.ezhomesixgod.excutor.DefaultEzHomeExcutor;
import com.ezhomesixgod.mapper.MapperMethod;
import com.ezhomesixgod.mapper.ShopMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EzHomeSqlSession sqlSession =new DefaultEzHomeSqlSession();
        ShopMapper shopMapper =sqlSession.getMapper(ShopMapper.class);
        Shop shop = shopMapper.findShopById(100);
        System.out.println(shop.toString());

    }
}
