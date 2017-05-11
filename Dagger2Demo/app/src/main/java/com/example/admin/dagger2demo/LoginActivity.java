package com.example.admin.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.et_admin)
    private EditText et_admin;

    @BindView(R.id.et_pass)
    private EditText et_pass;

    @BindView(R.id.btn_login)
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
