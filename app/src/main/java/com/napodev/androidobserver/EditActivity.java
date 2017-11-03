package com.napodev.androidobserver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.napodev.androidobserver.observables.SettingsEntity;
import com.napodev.androidobserver.observables.UserEntity;

public class EditActivity extends AppCompatActivity {
    private UserEntity userEntity;
    private SettingsEntity settingsEntity;

    private EditText userName;
    private EditText userAge;
    private EditText userMusic;
    private EditText userCountry;
    private EditText userCity;
    private EditText userBio;
    private Button btnSave;
    private Button btnBack;
    private Switch sOnlineStatus;
    private Switch sPublicStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        userName = (EditText) findViewById(R.id.userName);
        userAge = (EditText) findViewById(R.id.userAge);
        userMusic = (EditText) findViewById(R.id.userMusic);
        userCountry = (EditText) findViewById(R.id.userCountry);
        userCity = (EditText) findViewById(R.id.userCity);
        userBio = (EditText) findViewById(R.id.userBio);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnBack = (Button) findViewById(R.id.btnBack);
        sOnlineStatus = (Switch) findViewById(R.id.sOnlineStatus);
        sPublicStatus = (Switch) findViewById(R.id.sPublicStatus);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
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

        setupUserData();
    }

    private void setupUserData() {
        userName.setText(userEntity.getName());
        userAge.setText(String.valueOf(userEntity.getAge()));
        userMusic.setText(userEntity.getMusic());
        userCountry.setText(userEntity.getCountry());
        userCity.setText(userEntity.getCity());
        userBio.setText(userEntity.getBio());
        sOnlineStatus.setChecked(settingsEntity.isOnlineStatus());
        sPublicStatus.setChecked(settingsEntity.isPublicStatus());
    }

    private void updateData() {
        userEntity.setName(userName.getText().toString());
        userEntity.setAge(Integer.parseInt(userAge.getText().toString()));
        userEntity.setMusic(userMusic.getText().toString());
        userEntity.setCountry(userCountry.getText().toString());
        userEntity.setCity(userCity.getText().toString());
        userEntity.setBio(userBio.getText().toString());
        userEntity.notifyObservers();

        settingsEntity.setPublicStatus(sPublicStatus.isChecked());
        settingsEntity.setOnlineStatus(sOnlineStatus.isChecked());
        settingsEntity.notifyObservers();
    }
}
