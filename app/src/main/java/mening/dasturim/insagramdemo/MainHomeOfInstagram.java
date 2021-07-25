package mening.dasturim.insagramdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import mening.dasturim.insagramdemo.adapter.RecyclerAdapter;
import mening.dasturim.insagramdemo.data.RecyclerViewData;


public class MainHomeOfInstagram extends Fragment implements View.OnClickListener {

    NavController navController;
    ArrayList<RecyclerViewData> arrayList;
    RecyclerView recyclerView;
    VideoView videoView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // MediaController mediaController=new MediaController(getActivity());
        //  mediaController.setAnchorView(videoView);
        //  videoView.setMediaController(mediaController);
        return inflater.inflate(R.layout.fragment_main_home_of_instagram, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        view.findViewById(R.id.chat_message).setOnClickListener(this::onClick);
        videoView = view.findViewById(R.id.video_view);
        recyclerView = view.findViewById(R.id.recyclerview);

/*

         MediaController mediaController=new MediaController(getActivity());
          mediaController.setAnchorView(videoView);
          videoView.setMediaController(mediaController);


 */
        arrayList = new ArrayList<>();

        arrayList.add(new RecyclerViewData(R.drawable.music_bas, "muzic_xit", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.coffevideo));

        arrayList.add(new RecyclerViewData(R.drawable.sea, "travel_channel", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.beach));

        arrayList.add(new RecyclerViewData(R.drawable.woman, "anna_anna152", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.flowers));

        arrayList.add(new RecyclerViewData(R.drawable.waterfall, "montains5454c", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.fotage));

        arrayList.add(new RecyclerViewData(R.drawable.birds, "animals862.", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.jellyfish));

        arrayList.add(new RecyclerViewData(R.drawable.guitar, "good_morning", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.coffevideo));

        arrayList.add(new RecyclerViewData(R.drawable.city, "wollpappers156", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.photographer));

        arrayList.add(new RecyclerViewData(R.drawable.dog, "anim", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.red));

        arrayList.add(new RecyclerViewData(R.drawable.elephant, "elaphants_in_africa", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.sheep));

        arrayList.add(new RecyclerViewData(R.drawable.road, "social_media", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.social_media));
        arrayList.add(new RecyclerViewData(R.drawable.waterfall, "summer_2021", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.summer));

        arrayList.add(new RecyclerViewData(R.drawable.owl, "birds468865", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.swans));

        arrayList.add(new RecyclerViewData(R.drawable.woman, "models5", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.women));

        arrayList.add(new RecyclerViewData(R.drawable.sea, "ocian", "android.resource://" +
                getActivity().getPackageName() + "/" + R.raw.coffevideo));


        RecyclerView.Adapter adapter = new RecyclerAdapter(getActivity(), arrayList);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.chat_message:
                navController.navigate(R.id.action_mainHomeOfInstagram_to_messenger);
                break;
        }
    }


}