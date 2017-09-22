package com.q2tlibrary.decryption;

import com.xtempo.networklibrary.ErrorType;

/**
 * Created by Hemant on 7/24/2017.
 */

public enum Type implements ErrorType {
    AUTHENTICATION("Authentication"),
    ACCESS("Access"),
    SYSTEM("System"),
    VERSION("version");

    private String errorTypeKey;

    Type(String errorTypeKey) {
        this.errorTypeKey = errorTypeKey;
    }

    @Override
    public String getErrorTypeKey() {
        return errorTypeKey;
    }
}
