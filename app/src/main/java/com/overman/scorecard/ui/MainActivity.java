package com.overman.scorecard.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.overman.scorecard.R;
import com.overman.scorecard.adapters.HoleAdapter;
import com.overman.scorecard.scores.Hole;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    private static final String PREFS_FILE = "com.overman.scorecardapp.preferences";
    private static final String KEY_SCORE = "KEY_HOLE";
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mSharedPreferences;
    public static final String TAG = MainActivity.class.getSimpleName();
    private Hole[] mHoles;

    @Bind(R.id.holeList) ListView mHoleList;
/*    @Bind(R.id.holeNumberView) TextView mHoleNumberView;
    @Bind(R.id.scoreTextView) TextView mScoreView;
    @Bind(R.id.plusButton) Button mPlusButton;
    @Bind(R.id.minusButton) Button mMinusButton;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    //    Log.d(TAG, "In onCreate()");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        if (mSharedPreferences = null) {
            mHoles = resetScores();
        } else {
            mHoles = new Hole[18];
            for (int i = 0; i < 18; i++) {
                mHoles[i] = new Hole();
                mHoles[i].setScore(mSharedPreferences.getInt(KEY_SCORE + i, 0));
            }
        }

    //    Log.d(TAG, "Starting HoleAdapter");
        HoleAdapter adapter = new HoleAdapter(this, mHoles);
        mHoleList.setAdapter(adapter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        for (int i = 0; i < 18; i++) {
            mEditor.putInt(KEY_SCORE + i, mHoles[i].getScore());
        }
        mEditor.apply();
    }

    private Hole[] resetScores() {
        Hole[] holes = new Hole[18];
        for(int i=0; i < 18; i++) {
            holes[i] = new Hole();
        }
        return holes;
    }
}
