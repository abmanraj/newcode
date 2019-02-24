package com.sporti.sporticlan;

/**
 * Created by smit on 4/11/2018.
 */

public class ModelOrder {
    /**
     * status : 1
     * rid : 4
     * message : Your order has been placed successfully
     */

    private int status;
    private int rid;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
