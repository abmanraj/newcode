package com.sporti.sporticlan;

import java.util.List;

/**
 * Created by smit on 4/3/2018.
 */

public class ModelCart {

    /**
     * status : 1
     * Message : Add to Cart Successfully
     * productList : [{"sp_name":"jhvjhvjhv","sp_id":2,"p_id":1,"sp_price":5500,"total_price":0,"unit":"unit","sp_image":"https://sporticlan.000webhostapp.com/upload_image/bbff70792555f7121af3f3267e46ec1b5847e7e2.png"}]
     */

    private String status;
    private String Message;
    private List<ProductListBean> productList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<ProductListBean> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductListBean> productList) {
        this.productList = productList;
    }

    public static class ProductListBean {
        /**
         * sp_name : jhvjhvjhv
         * sp_id : 2
         * p_id : 1
         * sp_price : 5500
         * total_price : 0
         * unit : unit
         * sp_image : https://sporticlan.000webhostapp.com/upload_image/bbff70792555f7121af3f3267e46ec1b5847e7e2.png
         */

        private String sp_name;
        private int sp_id;
        private int p_id;
        private int sp_price;
        private int total_price;
        private String unit;
        private String sp_image;

        public String getSp_name() {
            return sp_name;
        }

        public void setSp_name(String sp_name) {
            this.sp_name = sp_name;
        }

        public int getSp_id() {
            return sp_id;
        }

        public void setSp_id(int sp_id) {
            this.sp_id = sp_id;
        }

        public int getP_id() {
            return p_id;
        }

        public void setP_id(int p_id) {
            this.p_id = p_id;
        }

        public int getSp_price() {
            return sp_price;
        }

        public void setSp_price(int sp_price) {
            this.sp_price = sp_price;
        }

        public int getTotal_price() {
            return total_price;
        }

        public void setTotal_price(int total_price) {
            this.total_price = total_price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getSp_image() {
            return sp_image;
        }

        public void setSp_image(String sp_image) {
            this.sp_image = sp_image;
        }
    }
}
