package com.apps.cyberco2.unfaded.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.MainActivity;
import com.apps.cyberco2.unfaded.customer.MainCustomerActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityLogInBinding;
import com.apps.cyberco2.unfaded.retroapi.ApiClient;
import com.apps.cyberco2.unfaded.retroapi.LoginUser;
import com.apps.cyberco2.unfaded.retroapi.UserPOJO;
import com.apps.cyberco2.unfaded.retroapi.ApiInterface;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.apps.cyberco2.unfaded.utils.Constants.ACCOUNT_TYPE;

public class LogInActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    ActivityLogInBinding logInBinding;
    int accountType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logInBinding = DataBindingUtil.setContentView(this, R.layout.activity_log_in);
        Paper.init(this);
        accountType = Paper.book().read(ACCOUNT_TYPE);
        // Set up progress before call
        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        logInBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEmail = (EditText) findViewById(R.id.et_email);
                EditText editTextPassword = (EditText) findViewById(R.id.et_password);
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                LoginUser user = new LoginUser(email, password);
                Call<UserPOJO> call = apiInterface.loginUser(user);

                //progressDoalog.show();
                Toast.makeText(getApplicationContext(),
                    "Redirecting...",Toast.LENGTH_LONG).show();
                call.enqueue(new Callback<UserPOJO>() {


                    @Override
                    public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {
                        if(response.body().getMessage() == "Invalid Login Credentials"){
                            //progressDoalog.dismiss();
                            Toast.makeText(getApplicationContext(),
                                "Wrong Credentials...",Toast.LENGTH_SHORT).show();

                        }
                        if(response.body().getToken() != null){

                            moveToHome();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserPOJO> call, Throwable t) {
                        call.cancel();
                        Toast.makeText(getApplicationContext(),
                            "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        logInBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
                finish();
            }
        });
        logInBinding.txtForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForget = new Intent(LogInActivity.this, ForgetPwdActivity.class);
                startActivity(intentForget);
                finish();
            }
        });
        logInBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(LogInActivity.this, SelectAccountActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }

    public void moveToHome() {

        if (accountType == 1) {
            Intent mainIntent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        } else {
            Intent mainIntent = new Intent(LogInActivity.this, MainCustomerActivity.class);
            startActivity(mainIntent);
            finish();
        }

    }

    public void moveToForgetPWD() {

    }

    public void moveTORegister() {

    }

}
