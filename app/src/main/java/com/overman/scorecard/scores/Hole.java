package com.overman.scorecard.scores;

import android.util.Log;

/**
 * Created by Michael on 2/25/2016.
 */
public class Hole {
    private static final String TAG = Hole.class.getSimpleName();
    private int mScore = 0;

    public Hole() {
        Log.d(TAG, "Creating a Hole");
    }
    public int getScore() {
        return mScore;
    }
    public void setScore(int i) {
        mScore = i;
    }

    public void incrementScore() {
        mScore += 1;
    }

    public void decrementScore() {
        mScore -= 1;
        if (mScore < 0) mScore = 0;
    }


}
