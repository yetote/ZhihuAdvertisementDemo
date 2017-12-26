package rugu.yetote.com.zhihuadvertisementdemo;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * rugu.yetote.com.zhihuadvertisementdemo
 *
 * @author Swg
 * @date 2017/12/22 15:29
 */
public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<MyModel> list;
    private static final int IS_ADVERTISEMENT = 1;
    private static final int NOT_ADVERTISEMENT = 2;
    private static final int IS_FOLLOW = 3;
    private static final String TAG = "MyAdapter";
    public static final String AD_TAG = "广告";
    public static final String FOLLOW_TAG = "炉石传说";

    public MyAdapter(Context context, ArrayList<MyModel> list) {
        this.context = context;
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title, content;

        public ImageView getIv() {
            return iv;
        }

        public TextView getTitle() {
            return title;
        }

        public TextView getContent() {
            return content;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.item_content_iv);
            title = itemView.findViewById(R.id.item_content_cardView_rl_title);
            content = itemView.findViewById(R.id.item_content_cardView_rl_content);

        }
    }

    class MyAdViewHolder extends RecyclerView.ViewHolder {
        public MyAdViewHolder(View itemView) {
            super(itemView);
        }
    }

    class MyFollowViewHolder extends RecyclerView.ViewHolder {
        private ImageView followIv;
        private TextView followTitle, followContent, followDate, followDiscuss, followTag;

        public TextView getFollowTag() {
            return followTag;
        }

        public ImageView getFollowIv() {
            return followIv;
        }

        public TextView getFollowTitle() {
            return followTitle;
        }

        public TextView getFollowContent() {
            return followContent;
        }

        public TextView getFollowDate() {
            return followDate;
        }

        public TextView getFollowDiscuss() {
            return followDiscuss;
        }

        public MyFollowViewHolder(View itemView) {
            super(itemView);
            followIv = itemView.findViewById(R.id.item_follow_iv);
            followTitle = itemView.findViewById(R.id.item_follow_title);
            followContent = itemView.findViewById(R.id.item_follow_content);
            followDate = itemView.findViewById(R.id.item_follow_date);
            followDiscuss = itemView.findViewById(R.id.item_follow_discuss);
            followTag = itemView.findViewById(R.id.item_follow_tag);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v;
        Log.e(TAG, "onCreateViewHolder: " + viewType);
        if (viewType == IS_ADVERTISEMENT) {
            v = layoutInflater.inflate(R.layout.item_advertisement, parent, false);
            return new MyAdViewHolder(v);
        } else if (viewType == IS_FOLLOW) {
            v = layoutInflater.inflate(R.layout.item_follow, parent, false);
            v.setOnClickListener(view -> Log.e(TAG, "onClick: " + "关注"));
            return new MyFollowViewHolder(v);
        } else if (viewType == NOT_ADVERTISEMENT) {
            v = layoutInflater.inflate(R.layout.item_content, parent, false);
            v.setOnClickListener(view -> Log.e(TAG, "onClick: " + "非广告"));
            return new MyViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            Glide.with(context).load(list.get(position).getImg()).into(((MyViewHolder) holder).getIv());
            ((MyViewHolder) holder).getTitle().setText(list.get(position).getTitle());
            ((MyViewHolder) holder).getContent().setText(list.get(position).getContent());
        } else if (holder instanceof MyFollowViewHolder) {
            Glide.with(context).load(list.get(position).getImg()).into(((MyFollowViewHolder) holder).getFollowIv());
            ((MyFollowViewHolder) holder).getFollowTag().setText(list.get(position).getTag());
            ((MyFollowViewHolder) holder).getFollowTitle().setText(list.get(position).getTitle());
            ((MyFollowViewHolder) holder).getFollowContent().setText(list.get(position).getContent());
            ((MyFollowViewHolder) holder).getFollowDate().setText(list.get(position).getDate());
            ((MyFollowViewHolder) holder).getFollowDiscuss().setText(list.get(position).getDiscuss() + "");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        int tag = 0;
        String s = list.get(position).getTag();
        if (s.equals(AD_TAG)) {
            return IS_ADVERTISEMENT;
        } else if (s.equals(FOLLOW_TAG)) {
            return IS_FOLLOW;
        } else {
            return NOT_ADVERTISEMENT;
        }
//        return tag;
    }
}
