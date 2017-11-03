package com.napodev.androidobserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.napodev.androidobserver.observables.SettingsEntity;
import com.napodev.androidobserver.observables.UserEntity;

import java.util.Observable;
import java.util.Observer;

public class DetailActivity extends AppCompatActivity implements Observer {
    private UserEntity userEntity;
    private SettingsEntity settingsEntity;

    private TextView userName;
    private TextView userAge;
    private TextView userMusic;
    private TextView userCountry;
    private TextView userCity;
    private TextView userBio;
    private Button btnEdit;
    private Button btnBack;
    private Switch sOnlineStatus;
    private Switch sPublicStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        userName = (TextView) findViewById(R.id.userName);
        userAge = (TextView) findViewById(R.id.userAge);
        userMusic = (TextView) findViewById(R.id.userMusic);
        userCountry = (TextView) findViewById(R.id.userCountry);
        userCity = (TextView) findViewById(R.id.userCity);
        userBio = (TextView) findViewById(R.id.userBio);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnBack = (Button) findViewById(R.id.btnBack);
        sOnlineStatus = (Switch) findViewById(R.id.sOnlineStatus);
        sPublicStatus = (Switch) findViewById(R.id.sPublicStatus);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this, EditActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        userEntity = UserEntity.getInstance();
        settingsEntity = SettingsEntity.getInstance();
        userEntity.addObserver(this);
        settingsEntity.addObserver(this);

        setupUserBasicData();
        setupUserSettings();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userEntity.deleteObserver(this);
        settingsEntity.deleteObserver(this);
    }

    @Override
    public void update(Observable observable, Object o) {
        if (observable instanceof UserEntity) {
            setupUserBasicData();
        } else if (observable instanceof SettingsEntity) {
            setupUserSettings();
        }
    }

    private void setupUserBasicData() {
        userName.setText(userEntity.getName());
        userAge.setText(String.valueOf(userEntity.getAge()));
        userMusic.setText(userEntity.getMusic());
        userCountry.setText(userEntity.getCountry());
        userCity.setText(userEntity.getCity());
        userBio.setText(userEntity.getBio());

        sOnlineStatus.setChecked(settingsEntity.isOnlineStatus());
        sPublicStatus.setChecked(settingsEntity.isPublicStatus());
    }

    private void setupUserSettings() {
        sOnlineStatus.setChecked(settingsEntity.isOnlineStatus());
        sPublicStatus.setChecked(settingsEntity.isPublicStatus());
    }
}
