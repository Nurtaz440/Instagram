package mening.dasturim.insagramdemo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import mening.dasturim.insagramdemo.ChatFragment;
import mening.dasturim.insagramdemo.Messenger;
import mening.dasturim.insagramdemo.RoomFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private static final  int numOfTAbs=2;
    public ViewPagerAdapter(@NonNull Messenger fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new ChatFragment();
            default:
                return new RoomFragment();
        }

    }

    @Override
    public int getItemCount() {
        return numOfTAbs;
    }
}
