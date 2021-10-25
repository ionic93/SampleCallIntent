package com.example.samplecallintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
    }

    public void callIntentImplicit(View view) {
        String data = editText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data));
        startActivity(intent);
    }

    public void callIntentExplicit(View view) {
        Intent intent = new Intent();
        //기존은 다른 액티비티를 띄울 때이지만, 지금은 다른 사람이 만든 앱도 띄울 수 있다.
        ComponentName name = new ComponentName("com.example.samplecallintent",
                "com.example.samplecallintent.MenuActivity");
        intent.setComponent(name);
        startActivityForResult(intent,101);
    }
}