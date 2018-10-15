package com.ezhomesixgod;

import com.ezhomesixgod.bean.Shop;
import com.ezhomesixgod.mybatis.ShopMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class App 
{

    private static final Logger logger =Logger.getLogger(App.class);
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );

        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        ShopMapper shopMapper=sqlSession.getMapper(ShopMapper.class);

        Shop shop = shopMapper.selectOneById(710);


        logger.info(shop.getName());

    }
}
