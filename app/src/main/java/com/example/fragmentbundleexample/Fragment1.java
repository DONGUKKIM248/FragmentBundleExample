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

public class Fragment1 extends Fragment {
    private View view;
    private TextView tv_frag1;
    private Button btn_move;
    private String result;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1,container,false);
        //Activity가 아니라 Fragment 할 때는 view.findViewById를 해야한다.(findViewById하면 안됨)
        tv_frag1 = view.findViewById(R.id.tv_frag1);
        btn_move = view.findViewById(R.id.btn_move);

//받는부분
        if(getArguments() != null) { //2에서 setArguments()를 통해 받고, 1에서 getArguments()로 받아온 값이 null이 아니면
            result = getArguments().getString("fromFrag2"); // Fragment2로부터 setArguemtns된 data를 받아온다.
            tv_frag1.setText(result);
        }

        //1->2이동
        btn_move.setOnClickListener(new View.OnClickListener(){ //프래그먼트 2로 이동
            @Override
            public void onClick(View view){//여기서 문자열을 fragment_2로 넘겨준다.
                Bundle bundle = new Bundle(); //무언가를 담을 준비를 할 수 있는 보따리 or 꾸러미
                bundle.putString("fromFrag1","홍드로이드 프래그먼트 1"); //키값, data
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                // Fragment는 Activity안에품고있는 자식들이라서 getActivity()가 가능하다.
                //transaction:fragment를 관리하는 친구(frament 교체/ 가져옴 / 현재 값 어떤거 있는지 검사)
                Fragment2 fragment2 = new Fragment2(); //Fragment2를 생성하고,
                fragment2.setArguments(bundle); //setArguments를 통해서 fragment2에 bundle을 넣어준다.
                transaction.replace(R.id.frameLayout,fragment2); //startActivity
                //첫번째인자: fragment조각을 1,2로 바꿔줄 친구를 넣는다(교체할 화면에 대한 영역을 표시), 두 번쨰 인자: 교체할 화면에 뭘로 바꿀 것인가
                // 만들어진 fragment2에 bundle을 넣고 보낸다. 현재 fragment를 frament2로 교체(replace)해줘
                transaction.commit(); //commit해야 교체가 완료된다.


            }
        });

        return view;
    }
}
