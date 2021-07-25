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


public class MainFargment extends Fragment implements View.OnClickListener {

    Button btn;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {


       return inflater.inflate(R.layout.fragment_main_fargment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);



        view.findViewById(R.id.button).setOnClickListener(this::onClick);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                navController.navigate(R.id.action_mainFargment_to_password);
                break;
        }
    }
}