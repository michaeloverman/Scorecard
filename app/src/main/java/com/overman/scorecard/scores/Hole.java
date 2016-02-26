package com.overman.scorecard.scores;

import android.util.Log;

/**
 * Created by Michael on 2/25/2016.
 */
public class Hole {
    private static final String TAG = Hole.class.getSimpleName();
    private int score = 0;

    public Hole() {
        Log.d(TAG, "Creating a Hole");
    }
    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score += 1;
    }

    public void decrementScore() {
        score -= 1;
    }


}
