package com.overman.scorecard.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.overman.scorecard.R;
import com.overman.scorecard.scores.Hole;

/**
 * Created by Michael on 2/25/2016.
 */
public class HoleAdapter extends BaseAdapter {
    
    private static final String TAG = HoleAdapter.class.getSimpleName();
    private Context mContext;
    private Hole[] mHoles;

/*    @Bind(R.id.holeNumberView) TextView mHoleNumberView;
    @Bind(R.id.scoreTextView) TextView mScoreView;
    @Bind(R.id.plusButton) Button mPlusButton;
    @Bind(R.id.minusButton) Button mMinusButton;
*/

    public HoleAdapter(Context context, Hole[] holes) {
        Log.d(TAG, "In HoleAdapter");
        mContext = context;
        mHoles = holes;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.hole_list_item, null);
            holder = new ViewHolder();
            holder.holeNumberView = (TextView) convertView.findViewById(R.id.holeNumberView);
            holder.scoreView = (TextView) convertView.findViewById(R.id.scoreTextView);
            holder.plusButton = (Button) convertView.findViewById(R.id.plusButton);
            holder.minusButton = (Button) convertView.findViewById(R.id.minusButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Hole hole = mHoles[position];
        final int holeNumber = position + 1;

        holder.holeNumberView.setText("Hole " + holeNumber + ":");
        holder.scoreView.setText(hole.getScore() + "");

        holder.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hole.incrementScore();
                holder.scoreView.setText(hole.getScore() + "");
            }
        });
        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hole.decrementScore();
                holder.scoreView.setText(hole.getScore() + "");
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        TextView holeNumberView;
        TextView scoreView;
        Button plusButton;
        Button minusButton;

    }
}
