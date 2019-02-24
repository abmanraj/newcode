package com.sporti.sporticlan;

/**
 * Created by smit on 3/28/2018.
 */

public class ModelProfile {
    /**
     * status : 1
     * userDetails : {"rid":"4","name":"smir","gender":"Male","mobile":"9173382825","email":"smit@gmail.com","address":"harihar"}
     * message : User Details Listed Successfully
     */

    private int status;
    private UserDetailsBean userDetails;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserDetailsBean getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsBean userDetails) {
        this.userDetails = userDetails;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class UserDetailsBean {
        /**
         * rid : 4
         * name : smir
         * gender : Male
         * mobile : 9173382825
         * email : smit@gmail.com
         * address : harihar
         */

        private String rid;
        private String name;
        private String gender;
        private String mobile;
        private String email;
        private String address;

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
