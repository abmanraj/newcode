package com.sporti.sporticlan;

/**
 * Created by smit on 4/10/2018.
 */

public class Modeledit {


    /**
     * status : 1
     * UserDetails : {"rid":4,"name":"smit","gender":"male","mobile":9173382825,"email":"smit2371997@gmail.com","address":"harihar"}
     * message : You are successfully updated your profile
     */

    private int status;
    private UserDetailsBean UserDetails;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserDetailsBean getUserDetails() {
        return UserDetails;
    }

    public void setUserDetails(UserDetailsBean UserDetails) {
        this.UserDetails = UserDetails;
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
         * name : smit
         * gender : male
         * mobile : 9173382825
         * email : smit2371997@gmail.com
         * address : harihar
         */

        private int rid;
        private String name;
        private String gender;
        private long mobile;
        private String email;
        private String address;

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
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

        public long getMobile() {
            return mobile;
        }

        public void setMobile(long mobile) {
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
