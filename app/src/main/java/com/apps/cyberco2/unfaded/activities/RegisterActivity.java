package com.apps.cyberco2.unfaded.activities;

import static com.apps.cyberco2.unfaded.utils.Constants.ACCOUNT_TYPE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.MainActivity;
import com.apps.cyberco2.unfaded.brand.activities.SubcriptionActivity;
import com.apps.cyberco2.unfaded.customer.MainCustomerActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityRegisterBinding;
import com.apps.cyberco2.unfaded.retroapi.ApiClient;
import com.apps.cyberco2.unfaded.retroapi.ApiInterface;
import com.apps.cyberco2.unfaded.retroapi.LoginUser;
import com.apps.cyberco2.unfaded.retroapi.RegisterUser;
import com.apps.cyberco2.unfaded.retroapi.UserPOJO;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding registerBinding;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        Paper.init(this);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        registerBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEmail = (EditText) findViewById(R.id.et_email);
                EditText editTextPassword = (EditText) findViewById(R.id.et_password);
                EditText editTextName = (EditText) findViewById(R.id.et_name);
                EditText editTextPhone = (EditText) findViewById(R.id.et_phone);

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();

                RegisterUser user = new RegisterUser(email, password,name,phone,1);
                Call<UserPOJO> call = apiInterface.registerUser(user);
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
                            Intent mainIntent = new Intent(RegisterActivity.this, MainCustomerActivity.class);
                            startActivity(mainIntent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<UserPOJO> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),
                            "Wrong Credentials...",Toast.LENGTH_SHORT).show();
                        call.cancel();
                    }
                });
            }
        });

        registerBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(RegisterActivity.this, LogInActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
