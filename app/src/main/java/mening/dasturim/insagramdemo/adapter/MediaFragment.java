package mening.dasturim.insagramdemo.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import mening.dasturim.insagramdemo.R;

public class MediaFragment extends Fragment {


    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_media, container, false);
        gridView = view.findViewById(R.id.grid_view);


        gridView.setAdapter(new GrideAdapter(this));

        return view;
    }
}