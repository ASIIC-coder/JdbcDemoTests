package com.ahg.pojo;

public class BrandProduct {
    //id主键
    private Integer id;
    //品牌名称
    private String name;
    //产品存货
    private Integer quantity_in_stock;
    //产品单价
    private Double unit_price;

    @Override
    public String toString() {
        return "BrandProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity_in_stock=" + quantity_in_stock +
                ", unit_price=" + unit_price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity_in_stock() {
        return quantity_in_stock;
    }

    public void setQuantity_in_stock(Integer quantity_in_stock) {
        this.quantity_in_stock = quantity_in_stock;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }
}
