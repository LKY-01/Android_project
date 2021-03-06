package com.example.mywechat;
import java.io.Serializable;

public class GoodsEntity implements Serializable{
    public String imgPath;//图片地址
    public String goodsName;//货物名称
    public String goodsPrice;//货物价格

    public GoodsEntity(){};
    //图片的路径获取方法
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    //商品名字的获取方法
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    //商品价格的获取方法
    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "GoodsEntity{" +
                "imgPath='" + imgPath + '\'' +
                ", goodsName='" + goodsName + '\'' +

                ", goodsPrice='" + goodsPrice + '\'' +

                '}';
    }

}
