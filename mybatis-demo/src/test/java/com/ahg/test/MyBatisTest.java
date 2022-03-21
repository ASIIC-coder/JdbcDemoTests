package com.ahg.test;

import com.ahg.mapper.BrandMapper;
import com.ahg.pojo.BrandProduct;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4.执行方法
        List<BrandProduct> brandProducts = brandMapper.selectAll();
        System.out.println(brandProducts);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void selectById() throws IOException {
        //接收参数
        int id = 2;

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4.执行方法
        BrandProduct brandProduct = brandMapper.selectById(id);
        System.out.println(brandProduct);

        //5.释放资源
        sqlSession.close();
    }



    @Test
    public void selectByCondition() throws IOException {
        //接收参数
        String name = "chinese";

        //处理参数
        name = "%" + name + "%";


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4.执行方法
        List<BrandProduct> brandProducts = brandMapper.selectByCondition();
        System.out.println(brandProducts);

        //5.释放资源
        sqlSession.close();
    }



    @Test
    public void testAdd() throws IOException {

        //接收参数
        int id = 11;
        String name = "泸州";
        Integer quantity_in_stock = 24;
        Double unit_price = 8.1;

        BrandProduct brandProduct = new BrandProduct();
        brandProduct.setId(id);
        brandProduct.setName(name);
        brandProduct.setQuantity_in_stock(quantity_in_stock);
        brandProduct.setUnit_price(unit_price);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4.执行方法
        brandMapper.add(brandProduct);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testAdd2() throws IOException {//添加主键返回

        //接收参数
        int id = 12;
        String name = "泸州";
        Integer quantity_in_stock = 24;
        Double unit_price = 8.1;

        BrandProduct brandProduct = new BrandProduct();
        brandProduct.setId(id);
        brandProduct.setName(name);
        brandProduct.setQuantity_in_stock(quantity_in_stock);
        brandProduct.setUnit_price(unit_price);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //自动提交事务 -> true
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //4.执行方法
        brandMapper.add(brandProduct);
        Integer id1 = brandProduct.getId();
        System.out.println(id1);


        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testUpdate() throws IOException {

        //接收参数
        int id = 11;
        String name = "泸州月";
        Integer quantity_in_stock = 24;
        Double unit_price = 0.01;
        int idg = 7;

        BrandProduct brandProduct = new BrandProduct();
        brandProduct.setId(id);
        brandProduct.setName(name);
        brandProduct.setQuantity_in_stock(quantity_in_stock);
        brandProduct.setUnit_price(unit_price);
        brandProduct.setId(idg);


        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        int update = brandMapper.update(brandProduct);
        System.out.println(update);
        //5.释放资源
        sqlSession.close();
    }
}
