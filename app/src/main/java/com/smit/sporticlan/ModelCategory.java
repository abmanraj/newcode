package com.smit.sporticlan;

import java.util.List;

/**
 * Created by smit on 3/5/2018.
 */

public class ModelCategory {


    /**
     * status : 1
     * categoryList : [{"c_id":"1","c_name":"Badminton","c_image":"https://sporticlan.000webhostapp.com/upload_image/91bd9950249bdd18f7754ef42f6f4088a88760d6.png"},{"c_id":"2","c_name":"Cricket","c_image":"https://sporticlan.000webhostapp.com/upload_image/3813debb63963e2e109038251d7c4e263caeeeca.png"},{"c_id":"3","c_name":"Football","c_image":"https://sporticlan.000webhostapp.com/upload_image/cb2d6153c9968041bd5686faf42b1d7cbd17e9dc.png"},{"c_id":"4","c_name":"Hockey","c_image":"https://sporticlan.000webhostapp.com/upload_image/f2f6092105d1e276ee464df03875fd4708671113.png"},{"c_id":"5","c_name":"Tennis","c_image":"https://sporticlan.000webhostapp.com/upload_image/5282c4a9aa936d9c203da98ea90d57f737276c26.png"}]
     * Message : CategoryList fetched successfully
     */

    private String status;
    private String Message;
    private List<CategoryListBean> categoryList;

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

    public List<CategoryListBean> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryListBean> categoryList) {
        this.categoryList = categoryList;
    }

    public static class CategoryListBean {
        /**
         * c_id : 1
         * c_name : Badminton
         * c_image : https://sporticlan.000webhostapp.com/upload_image/91bd9950249bdd18f7754ef42f6f4088a88760d6.png
         */

        private String c_id;
        private String c_name;
        private String c_image;

        public String getC_id() {
            return c_id;
        }

        public void setC_id(String c_id) {
            this.c_id = c_id;
        }

        public String getC_name() {
            return c_name;
        }

        public void setC_name(String c_name) {
            this.c_name = c_name;
        }

        public String getC_image() {
            return c_image;
        }

        public void setC_image(String c_image) {
            this.c_image = c_image;
        }
    }
}
