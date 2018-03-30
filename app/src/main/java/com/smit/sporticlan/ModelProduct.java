package com.smit.sporticlan;

import java.util.List;

/**
 * Created by smit on 3/26/2018.
 */

public class ModelProduct {

    /**
     * status : 1
     * Message : ProductList fetched successfully
     * productList : [{"p_name":"baiunefefjnll","p_id":1,"p_image1":"https://sporticlan.000webhostapp.com/upload_image/a613f1bcc91f545867ee01c3d392b2a0cd36bbeb.png"}]
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
         * p_name : baiunefefjnll
         * p_id : 1
         * p_image1 : https://sporticlan.000webhostapp.com/upload_image/a613f1bcc91f545867ee01c3d392b2a0cd36bbeb.png
         */

        private String p_name;
        private int p_id;
        private String p_image1;

        public String getP_name() {
            return p_name;
        }

        public void setP_name(String p_name) {
            this.p_name = p_name;
        }

        public int getP_id() {
            return p_id;
        }

        public void setP_id(int p_id) {
            this.p_id = p_id;
        }

        public String getP_image1() {
            return p_image1;
        }

        public void setP_image1(String p_image1) {
            this.p_image1 = p_image1;
        }
    }
}
