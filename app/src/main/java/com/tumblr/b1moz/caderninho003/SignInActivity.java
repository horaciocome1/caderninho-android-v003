package com.tumblr.b1moz.caderninho003;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tumblr.b1moz.caderninho003.Helpers.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.activity_sign_in_email_edittext) EditText mEditTextEmail;
    @BindView(R.id.activity_sign_in_password_edittext) EditText mEditTextPassword;
    
    @OnClick({R.id.activity_sign_in_button, R.id.activity_sign_in_providers_button})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_sign_in_button:
                if (whichAccount() == -1)
                    Toast.makeText(this, "Conta nao encontrada", Toast.LENGTH_SHORT).show();
                else
                    startSession(whichAccount());
                break;
            case R.id.activity_sign_in_providers_button:
                // load firebase auth ui
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
    }
    
    private int whichAccount() {
        String email = mEditTextEmail.getText().toString();
        if (email.equalsIgnoreCase("costumer"))
            return Constants.USER_ACCOUNT_TYPE_COSTUMER;
        else if (email.equalsIgnoreCase("seller"))
            return Constants.USER_ACCOUNT_TYPE_SELLER;
        else if (email.equalsIgnoreCase("carrier"))
            return Constants.USER_ACCOUNT_TYPE_CARRIER;
        return -1;
    }
    
    private void startSession(final int account_type) {
        Intent intent = new Intent();
        intent.putExtra(Constants.PASSING_USER_ACCOUNT_TYPE_KEY, account_type);
        setResult(RESULT_OK, intent);
        finish();
    }

}
