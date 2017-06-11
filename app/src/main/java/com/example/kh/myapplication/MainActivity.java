package com.example.kh.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.kh.myapplication.COntroler.Communicator;
import com.example.kh.myapplication.Module.MySingleton;
import com.example.kh.myapplication.View.MyFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements Communicator{

    private MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);MySingleton.getMySingleton(this).StartVolley();
        if(savedInstanceState==null){
            myFragment = new MyFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.linefragment,myFragment,"MyFragment").commit();
        }else{
            myFragment  = (MyFragment) getSupportFragmentManager().findFragmentByTag("MyFragment");
        }


    }


    @Override
    public void xuly() {

    }
}
