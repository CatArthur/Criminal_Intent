package com.bignerdranch.android.criminal_intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager f=getSupportFragmentManager();
        Fragment fragment=f.findFragmentById(R.id.fragmentContainer);
        if(fragment==null){
            fragment=createFragment();
            f.beginTransaction().add(R.id.fragmentContainer,fragment).commit();
        }
    }
}
