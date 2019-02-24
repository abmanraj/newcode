package com.sporti.sporticlan;

import java.util.List;

/**
 * Created by smit on 4/3/2018.
 */

public class ModelList {

    /**
     * status : 1
     * orderDetail : [{"purchase_id":1251,"sp_id":2,"sp_name":"jhvjhvjhv","sp_image":"https://sporticlan.000webhostapp.com/upload_image/bbff70792555f7121af3f3267e46ec1b5847e7e2.png","sp_price":"5500","unit":"0","total_price":"0","order_date":"2018-04-03 07:59:49"}]
     * message : Your Cart Item List Successfully
     */

    private int status;
    private String message;
    private List<OrderDetailBean> orderDetail;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OrderDetailBean> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetailBean> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public static class OrderDetailBean {
        /**
         * purchase_id : 1251
         * sp_id : 2
         * sp_name : jhvjhvjhv
         * sp_image : https://sporticlan.000webhostapp.com/upload_image/bbff70792555f7121af3f3267e46ec1b5847e7e2.png
         * sp_price : 5500
         * unit : 0
         * total_price : 0
         * order_date : 2018-04-03 07:59:49
         */

        private int purchase_id;
        private int sp_id;
        private String sp_name;
        private String sp_image;
        private String sp_price;
        private String unit;
        private String total_price;
        private String order_date;

        public int getPurchase_id() {
            return purchase_id;
        }

        public void setPurchase_id(int purchase_id) {
            this.purchase_id = purchase_id;
        }

        public int getSp_id() {
            return sp_id;
        }

        public void setSp_id(int sp_id) {
            this.sp_id = sp_id;
        }

        public String getSp_name() {
            return sp_name;
        }

        public void setSp_name(String sp_name) {
            this.sp_name = sp_name;
        }

        public String getSp_image() {
            return sp_image;
        }

        public void setSp_image(String sp_image) {
            this.sp_image = sp_image;
        }

        public String getSp_price() {
            return sp_price;
        }

        public void setSp_price(String sp_price) {
            this.sp_price = sp_price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public String getOrder_date() {
            return order_date;
        }

        public void setOrder_date(String order_date) {
            this.order_date = order_date;
        }
    }
}
