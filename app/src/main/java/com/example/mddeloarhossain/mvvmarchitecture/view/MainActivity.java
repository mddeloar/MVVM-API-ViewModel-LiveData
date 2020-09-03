package com.example.mddeloarhossain.mvvmarchitecture.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mddeloarhossain.mvvmarchitecture.R;
import com.example.mddeloarhossain.mvvmarchitecture.adapter.UserAdapter;
import com.example.mddeloarhossain.mvvmarchitecture.model.User;
import com.example.mddeloarhossain.mvvmarchitecture.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;
    /*EditText number1, number2;
    Button resultbutton;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainActivityViewModel.getAllUserData().observe(this, new Observer<User[]>() {
            @Override
            public void onChanged(@Nullable User[] users) {
                recyclerView.setAdapter(new UserAdapter(users));

            }
        });

        /*number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        resultbutton = findViewById(R.id.resultButton);

        resultbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivityViewModel.additionFunction(number1.getText().toString(),number2.getText().toString()).observe(MainActivity.this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {

                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });*/
    }
}
