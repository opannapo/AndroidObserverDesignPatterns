package com.napodev.androidobserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.napodev.androidobserver.observables.SettingsEntity;
import com.napodev.androidobserver.observables.UserEntity;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer {
    private UserEntity userEntity;
    private SettingsEntity settingsEntity;

    private TextView userName;
    private TextView userAge;
    private TextView userMusic;
    private Button btnDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView) findViewById(R.id.userName);
        userAge = (TextView) findViewById(R.id.userAge);
        userMusic = (TextView) findViewById(R.id.userMusic);
        btnDetail = (Button) findViewById(R.id.btnDetail);

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailActivity.class));
            }
        });

        userEntity = UserEntity.getInstance();
        settingsEntity = SettingsEntity.getInstance();
        userEntity.addObserver(this);

        loadDataUser();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userEntity.deleteObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof UserEntity) {
            userName.setText(userEntity.getName());
            userAge.setText(String.valueOf(userEntity.getAge()));
            userMusic.setText(userEntity.getMusic());
        }
    }

    private void loadDataUser() {
        userEntity.setName("OpannapO")
                .setAge(29)
                .setMusic("Rock")
                .setCountry("Indonesia")
                .setCity("Jakarta")
                .setBio("OpannapO is Little People with a Big Dreams...");
        settingsEntity.setOnlineStatus(false)
                .setPublicStatus(false);

        userEntity.notifyObservers();
    }
}
