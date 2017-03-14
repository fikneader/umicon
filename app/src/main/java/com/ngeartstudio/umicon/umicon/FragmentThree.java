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
public class FragmentThree extends Fragment {

    public static FragmentThree newInstance(){
        return new FragmentThree();
    }
    Button dagang, manufaktur;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_three, container, false);

        dagang = (Button) rootView.findViewById(R.id.goDagang);
        manufaktur = (Button) rootView.findViewById(R.id.goManufaktur);

        manufaktur.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), ManufakturActivity.class);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }
}
