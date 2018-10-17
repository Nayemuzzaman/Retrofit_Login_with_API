package com.waltonbd.retrofitpera;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etUserName;
    private EditText etPassword;
    private Button loginButton;
    ResponseCreate responseCreate;
    User user;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.editTextUser);
        etPassword = findViewById(R.id.editTextPassword);

        loginButton = findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:

                try {
                    JSONObject login = new JSONObject();
                    login.put("username", etUserName.getText().toString().trim());
                    login.put("password", etPassword.getText().toString().trim());
                   
                    Log.e("tag",login.toString());

                    ResponseCreate.retrofitClient.getUser(login, new Callback<User>() {
                        @Override
                        public void onResponse(Call<User>call, Response<User> response) {
                           User user = response.body();
                            Log.e("inside","response");
                            if (response.isSuccessful() && user != null) {

                            User userName= response.body();
                                ArrayList<String>arrayList=new ArrayList<>();
                                user= (User) arrayList;

                            String accestoken=userName.getAccessToken();
                            Log.e("total response", accestoken);
                            } else {
                                Toast.makeText(MainActivity.this,
                                        String.format("Response is %s", String.valueOf(response.code()))
                                        , Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User>call, Throwable t) {
                            Toast.makeText(MainActivity.this,
                                    "Error is " + t.getMessage()
                                    , Toast.LENGTH_LONG).show();
                        }
                    });


                }
                 catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
