package com.example.kh.myapplication.View;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kh.myapplication.COntroler.Communicator;
import com.example.kh.myapplication.Module.BackgroundTask;
import com.example.kh.myapplication.Module.Contact;
import com.example.kh.myapplication.Module.MyRecyclerView;
import com.example.kh.myapplication.Module.MySingleton;
import com.example.kh.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private static final String TAG ="vo cong vinh" ;
    private Communicator communicator;
    private List<Contact> list  = new ArrayList<Contact>();
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private BackgroundTask backgroundTask;
    private StringBuffer s = new StringBuffer();

    public MyFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.btn)
    public void click(View v){
        Toast.makeText(v.getContext(), ""+s.toString()+"aaaaa: "+list.get(0).getPhone(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MySingleton.getMySingleton(getActivity()).StartVolley();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(savedInstanceState==null)
            list = backgroundTask.getlist();


            setRetainInstance(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyRecyclerView(getContext(), list));

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        communicator = (Communicator) context;
        if(backgroundTask==null)
            backgroundTask= new BackgroundTask(context);
            BackgroundTask.Onattach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        BackgroundTask.OnDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MySingleton.getMySingleton(getActivity()).StopVolley();
    }
}
