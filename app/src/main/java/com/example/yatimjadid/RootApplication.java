package com.example.yatimjadid;

import com.akexorcist.localizationactivity.ui.LocalizationApplication;
import com.google.firebase.FirebaseApp;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class RootApplication extends LocalizationApplication {

    private static RootApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        FirebaseApp.initializeApp(this);

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