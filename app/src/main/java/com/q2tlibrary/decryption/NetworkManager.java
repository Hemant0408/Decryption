package com.q2tlibrary.decryption;

import android.content.Context;
import android.support.annotation.NonNull;

import com.xtempo.networklibrary.NetworkLibrary;
import com.xtempo.networklibrary.network.manager.NetworkHelper;

/**
 * Created by aksha_000 on 12/24/2015.
 */
public class NetworkManager extends NetworkHelper {
    private static final String TAG = NetworkManager.class.getSimpleName();

    private static NetworkManager instance;

    public NetworkManager(Context context) {
        super(context);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new NetworkManager(context);
            NetworkLibrary.init(context, Type.ACCESS, Type.AUTHENTICATION, Type.SYSTEM, Type.VERSION);
        }
    }

    public static void getToken(@NonNull CorpRequest corpRequest) {
        if (instance != null)
            instance.createAndMakeGsonRequest(MethodType.POST, "/q2t_first_api", corpRequest, CorpResponse.class, null);
    }
}
