package com.ahg.mapper;


import com.ahg.pojo.BrandProduct;

import java.util.List;

public interface BrandMapper {
    /**
        查询所有
     */

    List<BrandProduct> selectAll();

    /**
     * 查看详情
     */
    BrandProduct selectById(int id);

    /**
     * 条件查询
     *  1.散装参数：如果方法中有多个参数，需要@Param()
     *  2.对象参数：
     *  3.map集合参数
     *
     */

//    List<BrandProduct> selectByCondition(@Param("name") String name, @Param("unit_price") Double unit_price);

    List<BrandProduct> selectByCondition();


    /**
     * 单条件-动态查询
     * @param brandProduct
     * @return
     */
    List<BrandProduct> selectByConditionSingle(BrandProduct brandProduct);
    /**
     * 添加数据
     */
    void add(BrandProduct brandProduct);

    void add2(BrandProduct brandProduct);

    /**
     * 修改数据
     */
    int update(BrandProduct brandProduct);

}
