package com.example.fragmentbundleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MainActivity에서 최초값을 띄워줘야 화면에 뜬다.
        //FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        // Fragment는 Activity안에품고있는 자식들이라서 getActivity()가 가능하다.
        //현재Activity이기 때문에 getActivity()를 할 필요 없다.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment1 fragment1 = new Fragment1(); //MainActivity에서 Fragment1을 선언해주고,
        //fragment1.setArguments(bundle);
        transaction.replace(R.id.frameLayout, fragment1); //Fragment1으로 진입을 해라
        transaction.commit(); //저장
    }
}