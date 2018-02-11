package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Bind;

public class DetailsActivity extends AppCompatActivity {

    PhoneBook phone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        ButterKnife.bind(this);

        Bundle recdData = getIntent().getExtras();

        System.out.println(recdData.get("name") );

       TextView name =  (TextView)findViewById(R.id.details_name);
        name.setText(recdData.get("name").toString());

        TextView phone =  (TextView)findViewById(R.id.details_mobile);
        phone.setText(recdData.get("phone").toString());
    }


}