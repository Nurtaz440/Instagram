package mening.dasturim.insagramdemo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import mening.dasturim.insagramdemo.CustomMedia;

public class ViewPagerAdapter2 extends FragmentStateAdapter {

    private static  final int numOfFragments=3;


    public ViewPagerAdapter2(@NonNull  FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
      switch (position){
          case 0:
              return new MediaFragment();
          case 1:
              return new ImportentMedia();
          default:
              return new CustomMedia();


      }
    }

    @Override
    public int getItemCount() {
        return numOfFragments;
    }
}
