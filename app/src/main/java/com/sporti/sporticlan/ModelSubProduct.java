package com.sporti.sporticlan;

import java.util.List;

/**
 * Created by smit on 3/26/2018.
 */

public class ModelSubProduct {


    /**
     * status : 1
     * Message : ProductList fetched successfully
     * subproductList : [{"sp_name":"ball","sp_id":1,"sp_image":"https://sporticlan.000webhostapp.com/upload_image/f61a804eb13ce046bd4e4e1729900e5fadac4617.png","sp_dis":" sfeg egwegf efgewgwe efw","sp_price":100},{"sp_name":"jhvjhvjhv","sp_id":2,"sp_image":"https://sporticlan.000webhostapp.com/upload_image/bbff70792555f7121af3f3267e46ec1b5847e7e2.png","sp_dis":" sfeg egwegf efgewgwe efw","sp_price":5500}]
     */

    private String status;
    private String Message;
    private List<SubproductListBean> subproductList;

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

    public List<SubproductListBean> getSubproductList() {
        return subproductList;
    }

    public void setSubproductList(List<SubproductListBean> subproductList) {
        this.subproductList = subproductList;
    }

    public static class SubproductListBean {
        /**
         * sp_name : ball
         * sp_id : 1
         * sp_image : https://sporticlan.000webhostapp.com/upload_image/f61a804eb13ce046bd4e4e1729900e5fadac4617.png
         * sp_dis :  sfeg egwegf efgewgwe efw
         * sp_price : 100
         */

        private String sp_name;
        private int sp_id;
        private String sp_image;
        private String sp_dis;
        private int sp_price;

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

        public String getSp_image() {
            return sp_image;
        }

        public void setSp_image(String sp_image) {
            this.sp_image = sp_image;
        }

        public String getSp_dis() {
            return sp_dis;
        }

        public void setSp_dis(String sp_dis) {
            this.sp_dis = sp_dis;
        }

        public int getSp_price() {
            return sp_price;
        }

        public void setSp_price(int sp_price) {
            this.sp_price = sp_price;
        }
    }
}
