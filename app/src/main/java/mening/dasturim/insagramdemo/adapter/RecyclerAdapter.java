package mening.dasturim.insagramdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.net.URI;
import java.util.ArrayList;

import mening.dasturim.insagramdemo.PersonProfile;
import mening.dasturim.insagramdemo.R;
import mening.dasturim.insagramdemo.data.RecyclerViewData;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<RecyclerViewData> arrayList;

    public RecyclerAdapter(Context context, ArrayList<RecyclerViewData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Nullable
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reyclerview_single_activity, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        RecyclerViewData recyclerViewData = arrayList.get(position);

        try {
            String link = recyclerViewData.getVideoView();
            MediaController mediaController = new MediaController(context);
            mediaController.setAnchorView(holder.videoView);
            Uri videoUri = Uri.parse(link);
            holder.videoView.setMediaController(mediaController);
            holder.videoView.setVideoURI(videoUri);
            holder.videoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.videoView.start();
                }
            });

        } catch (Exception e) {
            Toast.makeText(context, "Error connection", Toast.LENGTH_SHORT).show();

        }

        holder.imageView.setImageResource(arrayList.get(position).getImg());
        holder.textView.setText(arrayList.get(position).getTxt());

        holder.textView.setOnClickListener(v -> {


            Intent intent=new Intent(context, PersonProfile.class);
            context.startActivity(intent);

        });

        holder.moreVert.setOnClickListener(v -> {
            //  showPopUpMenu(v);

            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.Theme_MaterialComponents_BottomSheetDialog);

            View bottomSheetView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.bottom_sheet,
                    (LinearLayout) v.findViewById(R.id.bottom_shett_container));
            String[] listName = {"Report", "Turn on Post Notification", "Copy Link", "Share to...", "Unfollow", "Mute"};
            ListView listView = bottomSheetView.findViewById(R.id.list_view);

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, listName);

            listView.setOnItemClickListener((parent, view, position1, id) -> {
                switch (position1) {
                    case 0:
                        Toast.makeText(context, "Reported", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(context, "Notification turned on", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(context, "Copy in ClipBoard", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Intent intent=new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String videoPath="android.resource://" +
                                context.getPackageName() + "/" + R.raw.sheep;
                        Uri uri=Uri.parse(videoPath);
                        intent.putExtra(Intent.EXTRA_STREAM, uri);

                        view.getContext().startActivity(Intent.createChooser(intent, "Share Video"));

                      //  Toast.makeText(context, "Share to..", Toast.LENGTH_SHORT).show();
                        break;

                    case 4:
                        Toast.makeText(context, "Following", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(context, "UnMuted", Toast.LENGTH_SHORT).show();
                        break;

                }
            });

            listView.setAdapter(arrayAdapter);


            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, moreVert;
        TextView textView;
        VideoView videoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            imageView = itemView.findViewById(R.id.circleImageView);
            textView = itemView.findViewById(R.id.channel_name);
            videoView = itemView.findViewById(R.id.video_view);
            moreVert = itemView.findViewById(R.id.more_vert);

        }
    }
  /*  public void showPopUpMenu(View v){
        PopupMenu popupMenu=new PopupMenu(context, v);
        v.setOnTouchListener(popupMenu.getDragToOpenListener());
        popupMenu.inflate(R.menu.top_btn);

        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){

                case R.id.report:
                    Toast.makeText(context,"Reported",Toast.LENGTH_SHORT).show();
                    break;



                case R.id.notification:
                    Toast.makeText(context,"Notification turned on",Toast.LENGTH_SHORT).show();
                    break;


                case R.id.copy:
                    Toast.makeText(context,"Copy to Clipboard",Toast.LENGTH_SHORT).show();
                    break;


                case R.id.share:
                    Toast.makeText(context,"",Toast.LENGTH_SHORT).show();
                    break;


                case R.id.unfollow:
                    Toast.makeText(context,"Following",Toast.LENGTH_SHORT).show();
                    break;

                case R.id.mute:
                    Toast.makeText(context,"UnMute",Toast.LENGTH_SHORT).show();
                    break;


            }
            return true;

        });
        popupMenu.show();


    }

   */

}
