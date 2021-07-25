package mening.dasturim.insagramdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import mening.dasturim.insagramdemo.adapter.ViewPagerAdapter2;

public class PersonProfile extends AppCompatActivity {

    Button btn,btn2;
    ViewPager2 viewPager2;
    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.peson_profile);
        btn = findViewById(R.id.button3);
        btn2 = findViewById(R.id.button4);
        tabLayout = findViewById(R.id.tab_layout2);
        viewPager2 = findViewById(R.id.view_pager_profile);

        viewPager2.setAdapter(new ViewPagerAdapter2(this));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position) {
                    case 0:
                        tab.setIcon(R.drawable.ic_baseline_grid_on_24);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_baseline_live_tv_24);

                    case 2:
                        tab.setIcon(R.drawable.ic_baseline_perm_contact_calendar_24);
                }

            }
        });

        tabLayoutMediator.attach();


        btn.setOnClickListener(v -> {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this, R.style.Theme_MaterialComponents_BottomSheetDialog);


            View bottomView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_second,
                    v.findViewById(R.id.bottom_shett_con));


            String[] listname = {"Mute", "Restrict", "Unfollow"};

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listname);

            ListView listView = bottomView.findViewById(R.id.list_view2);

            listView.setOnItemClickListener((parent, view, position3, id) -> {
                switch (position3) {
                    case 0:

                        Toast.makeText(this, "Unmute", Toast.LENGTH_SHORT).show();
                        break;

                    case 1:
                        Toast.makeText(this, "Restricted", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(this, "Follow", Toast.LENGTH_SHORT).show();
                        break;
                }


            });

            listView.setAdapter(arrayAdapter);


            bottomSheetDialog.setContentView(bottomView);
            bottomSheetDialog.show();


        });

        btn2.setOnClickListener(v -> {
            Intent intent=new Intent(this,ChatingPage.class);
            startActivity(intent);
        });
    }
}
