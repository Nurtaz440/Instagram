package mening.dasturim.insagramdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Password extends Fragment implements View.OnClickListener {

    NavController navController;
    Button btn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);

        view.findViewById(R.id.button2).setOnClickListener(this::onClick);


    }

    @Override
    public void onClick(View v) {
        switch  (v.getId()){
            case R.id.button2:
                navController.navigate(R.id.action_password_to_mainHomeOfInstagram);
        }
    }
}