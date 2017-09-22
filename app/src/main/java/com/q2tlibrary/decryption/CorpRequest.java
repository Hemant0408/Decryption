package com.q2tlibrary.decryption;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aksha_000 on 12/24/2015.
 */
public class CorpRequest {
    @SerializedName("corp_token")
    private String corp_token;
    @SerializedName("emp_id")
    private String emp_id;
    @SerializedName("email_id")
    private String email_id;
    @SerializedName("phone_no")
    private String phone_no;

    public void setCorp_token(String corp_token) {
        this.corp_token = corp_token;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
}
