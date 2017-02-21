package com.ngeartstudio.umicon.umicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by docotel on 3/2/16.
 */
public class FragmentOne extends Fragment {
    public static FragmentOne newInstance(){
        return new FragmentOne();
    }
    Button dagang, manufaktur;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        dagang = (Button) rootView.findViewById(R.id.goDagang);
        manufaktur = (Button) rootView.findViewById(R.id.goManufaktur);

        dagang.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), DagangActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return rootView;
    }

}