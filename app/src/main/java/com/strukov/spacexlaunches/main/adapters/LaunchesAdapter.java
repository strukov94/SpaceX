package com.strukov.spacexlaunches.main.adapters;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.strukov.spacexlaunches.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.strukov.spacexlaunches.data.SpaceXContract.*;

/**
 * Created by Matthew on 18.02.2018.
 */

public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.LaunchesViewHolder> {

    private Cursor launches;
    private Context mContext;
    private OnClickLaunchListener mOnClickLaunch;

    public interface OnClickLaunchListener {
        void onClickLaunch(String[] links);
    }

    public LaunchesAdapter(Context context) {
        mContext = context;
        mOnClickLaunch = (OnClickLaunchListener) mContext;
    }


    @Override
    public LaunchesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.launch_row, parent, false);
        return new LaunchesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LaunchesViewHolder holder, int position) {
        launches.moveToPosition(position);
        holder.mTextDate.setText(getDate(launches.getLong(launches.getColumnIndexOrThrow(LaunchesEntry.DATE))));
        holder.mTextRocketName.setText(launches.getString(launches.getColumnIndexOrThrow(LaunchesEntry.ROCKET_NAME)));
        String details = launches.getString(launches.getColumnIndexOrThrow(LaunchesEntry.DETAILS));
        if (details == null) {
            details = "No details.";
            holder.mTextDetails.setTextColor(mContext.getResources().getColor(R.color.detailTextColor));
        }
        holder.mTextDetails.setText(details);
        try {
            File directory = mContext.getDir("images", Context.MODE_PRIVATE);
            File path = new File(directory, launches.getString(launches.getColumnIndexOrThrow(LaunchesEntry.IMAGE))+ ".png");
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(path));
            holder.mImageMission.setImageBitmap(bitmap);
        } catch (FileNotFoundException e) {
            Picasso.with(mContext).load(launches.getString(launches.getColumnIndexOrThrow(LaunchesEntry.IMAGE_URL))).resize(250, 250).into(holder.mImageMission);
        }
    }

    @Override
    public int getItemCount() {
        return launches == null ? 0 : launches.getCount();
    }

    public void swapAdapter(Cursor launches) {
        this.launches = launches;
        notifyDataSetChanged();
    }

    private String getDate(Long timeStamp) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm EEE, dd MMM yy");
        Date date = new Date(timeStamp * 1000L);
        return format.format(date);
    }

    class LaunchesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextDate;
        private TextView mTextRocketName;
        private TextView mTextDetails;
        private ImageView mImageMission;
        private View mViewLaunch;

        LaunchesViewHolder(View itemView) {
            super(itemView);

            mTextDate = itemView.findViewById(R.id.text_launch_date);
            mTextRocketName = itemView.findViewById(R.id.text_rocket_name);
            mTextDetails = itemView.findViewById(R.id.text_details);
            mImageMission = itemView.findViewById(R.id.image_mission_patch);
            mViewLaunch = itemView.findViewById(R.id.view_launch);

            mViewLaunch.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnClickLaunch.onClickLaunch(new String[]{launches.getString(launches.getColumnIndexOrThrow(LaunchesEntry.ARTICLE_LINK)),
                    launches.getString(launches.getColumnIndexOrThrow(LaunchesEntry.VIDEO_LINK))});
        }
    }
}