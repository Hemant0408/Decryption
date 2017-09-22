package com.q2tlibrary.decryption;

import com.google.gson.annotations.SerializedName;
import com.xtempo.networklibrary.network.data.inherit.Response;
import com.xtempo.networklibrary.network.parsing.Required;

/**
 * Created by aksha_000 on 7/8/2016.
 */
public class CorpResponse extends Response {
    @Required
    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }
}
