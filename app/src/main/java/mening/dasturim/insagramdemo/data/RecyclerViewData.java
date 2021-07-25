package mening.dasturim.insagramdemo.data;

import android.widget.VideoView;

public class RecyclerViewData {
    private Integer img;
    private String txt;
    private String videoView_url;

    public RecyclerViewData(Integer img, String txt, String videoView_url) {
        this.img = img;
        this.txt = txt;
        this.videoView_url = videoView_url;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getVideoView() {
        return videoView_url;
    }

    public void setVideoView(String videoView) {
        this.videoView_url = videoView;
    }
}
