package com.sporti.sporticlan;

/**
 * Created by smit on 4/3/2018.
 */

public class ModelMain {

    /**
     * status : 1
     * data : {"sp_name":"ball","sp_id":"1","p_id":"1","sp_dis":" sfeg egwegf efgewgwe efw","sp_price":"100","sp_image":"https://sporticlan.000webhostapp.com/upload_image/f61a804eb13ce046bd4e4e1729900e5fadac4617.png"}
     * message : User Details Listed Successfully
     */

    private int status;
    private DataBean data;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * sp_name : ball
         * sp_id : 1
         * p_id : 1
         * sp_dis :  sfeg egwegf efgewgwe efw
         * sp_price : 100
         * sp_image : https://sporticlan.000webhostapp.com/upload_image/f61a804eb13ce046bd4e4e1729900e5fadac4617.png
         */

        private String sp_name;
        private String sp_id;
        private String p_id;
        private String sp_dis;
        private String sp_price;
        private String sp_image;

        public String getSp_name() {
            return sp_name;
        }

        public void setSp_name(String sp_name) {
            this.sp_name = sp_name;
        }

        public String getSp_id() {
            return sp_id;
        }

        public void setSp_id(String sp_id) {
            this.sp_id = sp_id;
        }

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }

        public String getSp_dis() {
            return sp_dis;
        }

        public void setSp_dis(String sp_dis) {
            this.sp_dis = sp_dis;
        }

        public String getSp_price() {
            return sp_price;
        }

        public void setSp_price(String sp_price) {
            this.sp_price = sp_price;
        }

        public String getSp_image() {
            return sp_image;
        }

        public void setSp_image(String sp_image) {
            this.sp_image = sp_image;
        }
    }
}
