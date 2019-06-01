package com.example.sw_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    Button  signup;
    EditText email,login_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.useLogo);
        login_id = findViewById(R.id.password);
        button = findViewById(R.id.login);
     //   signup=findViewById(R.id.);
        //  lst=(ListView)findViewById(R.id.list);
       /* signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View m) {
                OpenActivity_signup();
            }
        });*/
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                act();
            //    OpenActivity_added();


            }

        });
    }
    public void act(){
        Intent intent= new Intent(this,home.class);
        startActivity( intent);
    }
}
