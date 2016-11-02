package com.munnasoft.munna.gcat.gcat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {
public EditText ed2;
    public TextView tv7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main2);
    ed2 =(EditText)findViewById(R.id.editText2);
        tv7=(TextView)findViewById(R.id.textView7);
        SharedPreferences settings=getSharedPreferences("Userinput",0);
        String oldpword=(settings.getString("password","aaaa"));
        if(oldpword.equals("IOT_GCAT_2017")){
            Toast.makeText(Main2Activity.this,"License Verified",Toast.LENGTH_LONG).show();
            Intent i=new Intent(Main2Activity.this,MainActivity.class);
            startActivity(i);
            ed2.setOnFocusChangeListener(new View.OnFocusChangeListener()
            {
                @Override
                public void onFocusChange(View v, boolean hasFocus)
                {
                    if (hasFocus)
                    {
                        if (ed2.getText().toString().compareTo("Enter One time License Key")==0)
                        {
                            ed2.setText("");
                        }
                    }
                }
            });

            ed2.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (ed2.getText().toString().compareTo("Enter One time License Key")==0)
                    {
                        ed2.setText("");
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (ed2.getText().toString().compareTo("Enter One time License Key")==0)
                    {
                        ed2.setText("");
                    }

                    }


                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }
    }

    public void abc(View view) {
        String s=ed2.getText().toString();
        if(s.equals("IOT_GCAT_2017")){

                SharedPreferences settings=getSharedPreferences("Userinput",0);
                SharedPreferences.Editor editor=settings.edit();
                editor.putString("password",ed2.getText().toString());
                editor.commit();
            Toast.makeText(Main2Activity.this,"License Verified",Toast.LENGTH_LONG).show();
            Intent i=new Intent(Main2Activity.this,MainActivity.class);
            startActivity(i);
            }else{
            tv7.setText("License is not Valid");
        }
            }
        }


