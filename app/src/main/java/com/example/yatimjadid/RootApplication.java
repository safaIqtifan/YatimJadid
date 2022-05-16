package com.example.yatimjadid;

import com.akexorcist.localizationactivity.ui.LocalizationApplication;
import com.google.firebase.FirebaseApp;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RootApplication extends LocalizationApplication {

    private static RootApplication instance;
    public static Realm dbRealm = null;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        FirebaseApp.initializeApp(this);

        Realm.init(this);

        String realmName = "jerusalem_news";
        RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).allowWritesOnUiThread(true).build();
        dbRealm = Realm.getInstance(config);

    }

    public static RootApplication getInstance() {
        return instance;
    }

    @NotNull
    @Override
    public Locale getDefaultLanguage() {
        return new Locale("ar");
    }
}