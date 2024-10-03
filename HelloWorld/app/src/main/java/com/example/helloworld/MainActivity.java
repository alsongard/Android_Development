package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        TextView txtHello = findViewById(R.id.textMsg);
//        txtHello.setText("Early in the morning..");
    }

    public void btnClick(View view)
    {
        // introduction part
//        EditText textUserName = findViewById(R.id.textUserName);
//        textUserName.getText().toString();
//        TextView txtMessage = findViewById(R.id.textMsg);
//        txtMessage.setText("Graduation Wakadinali");
//        txtMessage.setText("Hello " + textUserName.getText().toString());

        //challenge part 1
        // getting input fields
        EditText userName = findViewById(R.id.userName);
        EditText userEmail = findViewById(R.id.userEmail);
        EditText userAge = findViewById(R.id.userAge);

        // getting display fields
        TextView  usrName = findViewById(R.id.usrName);
        TextView usrEmail = findViewById(R.id.usrEmail);
        TextView usrAge = findViewById(R.id.usrAge);

        // to set the text of each of the text message
        usrName.setText(userName.getText().toString());
        usrEmail.setText(userEmail.getText().toString());
        usrAge.setText(userAge.getText());

    }

}
