package com.q2tlibrary.decryption;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

//    @Bind(R.id.tv_decrypt)
//    TextView tv_decrypt;

    @Bind(R.id.btn_open)
    Button btn_open;

    // private final String token = "SW+wIbPACURKw6LwfMvmXZzXWEwrA1PaQ5hyg/jKaV1xUj+krCMcI0FeqzNf4yavtCHYD00VggcQ/A9Pws6rWlotzZDEvc41h/TJ3XSMOhhyONLBZleOAcn4+YjwJTAl0tEWYzUmWrXgOJJ4J/ATE1lRGjpLPdqXzRe+eWuId+7kKfk5sV7VuWJK+CaWlaCzLNtiGE9QmgvUjPIz8RkW/A==";
    // private final String key = "sEcReTp@ssw0rd00";
    private static final String EXTRA_REQUEST_TOKEN = "request_token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        try {

        //byte[] bytesToDecrypt = Base64.decode(token.getBytes(), Base64.DEFAULT);
//            byte[] decryptedData = decrypt(key.getBytes(), token.getBytes());
//
//            String plainText = new String(decryptedData);
//            Log.e(TAG, plainText.trim());
//            tv_decrypt.setText(plainText.trim());

        //String plainText = new String(decryptedData,CharSet.forName("UTF-8"));
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
    }

//    private byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception {
//        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
//        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//        return cipher.doFinal(Base64.decode(encrypted, Base64.DEFAULT));
//    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @OnClick(R.id.btn_open)
    public void onClickButton() {
        CorpRequest corpRequest = new CorpRequest();
        corpRequest.setCorp_token("TESTTMLL");
        corpRequest.setEmp_id("atulbackend");
        corpRequest.setEmail_id("test@123");
        corpRequest.setPhone_no("1234654679");

        NetworkManager.getToken(corpRequest);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void corpTokenResonse(@NonNull CorpResponse corpResponse) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.xtempo.q2t");
        if (launchIntent != null) {
            launchIntent.putExtra(EXTRA_REQUEST_TOKEN, corpResponse.getToken());
            startActivity(launchIntent);
        }
        else
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.xtempo.q2t")));
        finish();
    }
}
