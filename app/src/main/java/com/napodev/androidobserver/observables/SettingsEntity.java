package com.napodev.androidobserver.observables;

import java.util.Observable;

/**
 * Created by opannapo on 11/4/17.
 */

public class SettingsEntity extends Observable {
    private boolean onlineStatus;
    private boolean publicStatus;

    private static SettingsEntity INSTANCE;

    public static SettingsEntity getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsEntity();
        }

        return INSTANCE;
    }

    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public SettingsEntity setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
        setChanged();
        return this;
    }

    public boolean isPublicStatus() {
        return publicStatus;
    }

    public SettingsEntity setPublicStatus(boolean publicStatus) {
        this.publicStatus = publicStatus;
        setChanged();
        return this;
    }
}
