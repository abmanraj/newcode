package com.smit.sporticlan;

/**
 * Created by smit on 2/27/2018.
 */

class Model {
    /**
     * status : 1
     * message : You have successfully logged in.
     * userDetail : {"rid":4}
     */

    private int status;
    private String message;
    private UserDetailBean userDetail;
    private int rid;

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

    public UserDetailBean getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetailBean userDetail) {
        this.userDetail = userDetail;
    }

    public int getRid() {
        return rid;
    }

    public static class UserDetailBean {
        /**
         * rid : 4
         */

        private int rid;

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }
    }
}
