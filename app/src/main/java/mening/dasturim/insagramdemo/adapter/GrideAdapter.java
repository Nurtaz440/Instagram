package mening.dasturim.insagramdemo.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import mening.dasturim.insagramdemo.R;

public class GrideAdapter extends BaseAdapter {

    MediaFragment context;



    int[] name={R.drawable.birds,R.drawable.city,R.drawable.guitar,R.drawable.elephant,R.drawable.guitar
            ,R.drawable.hindi2,R.drawable.birds,R.drawable.holiywwod6,R.drawable.guitar,R.drawable.elephant,R.drawable.guitar
            ,R.drawable.hindi1,R.drawable.birds,R.drawable.city,R.drawable.guitar,R.drawable.elephant,R.drawable.guitar
            ,R.drawable.hindi1,R.drawable.holiywwod5,R.drawable.holiywwod7,R.drawable.hindi3,R.drawable.owl,R.drawable.road
            ,R.drawable.sea,R.drawable.waterfall};

    public GrideAdapter(MediaFragment context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context.getContext());

        imageView.setImageResource(name[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(340,350));
        return imageView;
    }
}
