package com.example.fragmentbundleexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment2 extends Fragment {
    private View view;
    private TextView tv_frag2;
    private Button btn_move;
    private String result; //결과받아옴

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2,container,false);
        //Activity가 아니라 Fragment 할 때는 view.findViewById를 해야한다.(findViewById하면 안됨)
        tv_frag2 = view.findViewById(R.id.tv_frag2);
        btn_move = view.findViewById(R.id.btn_move);

        if(getArguments() != null)  // Fragment1에서 setArguments해온 값을 여기 getArguments()를 통해서 가져올 것이다.
            //Fragment1에서 버튼을 클릭안하면 getArgument가 null일 수 있다. (빈값이 아닐 때만 받아온다)
        {
            result = getArguments().getString("fromFrag1"); //Fragment1로부터 setArguments된 데이터를 받아온다.
            tv_frag2.setText(result); //textView에 뿌려준다.
        }


        btn_move.setOnClickListener(new View.OnClickListener(){ //프래그먼트 2 -> 1로 이동
            @Override
            public void onClick(View view){//여기서 문자열을 fragment_2로 넘겨준다.
                Bundle bundle = new Bundle(); //무언가를 담을 준비를 할 수 있는 보따리 or 꾸러미
                bundle.putString("fromFrag2","홍드로이드 프래그먼트 2"); //키값, data
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                //transaction:fragment를 관리하는 친구(frament 교체/ 가져옴 / 현재 값 어떤거 있는지 검사)

                Fragment1 fragment1 = new Fragment1(); //Fragment1을 객체 생성해주고,
                fragment1.setArguments(bundle); // 꾸러미에 담아뒀던 "홍드로이드 프래그먼트 2" 텍스트를 넣어준다.
                transaction.replace(R.id.frameLayout, fragment1); //fragment 교체
                transaction.commit(); //저장

            }
        });

        return view;
    }
}
