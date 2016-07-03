package com.sports.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // constants to identify the team
    final int TEAM_A = 1;
    final int TEAM_B = 2;

    // variables holding the score
    int teamAScore;
    int teamBScore;

    // array of Button IDs
    int[] btnIds;

    // TextViews displaying the score
    TextView teamAScoreTxtView;
    TextView teamBScoreTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the scores to zero
        teamAScore = 0;
        teamBScore = 0;

        // the button ids
        btnIds = new int[]{R.id.team_a_1pt_btn, R.id.team_a_2pt_btn, R.id.team_a_3pt_btn,
                R.id.team_b_1pt_btn, R.id.team_b_2pt_btn, R.id.team_b_3pt_btn,
                R.id.reset_btn};
        // attach an onClick listener to the buttons
        for (int id : btnIds) {
            ((Button) findViewById(id))
            .setOnClickListener(MainActivity.this);
        }

        // initialize the score TextViews
        teamAScoreTxtView = (TextView) findViewById(R.id.team_a_score);
        teamBScoreTxtView = (TextView) findViewById(R.id.team_b_score);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.team_a_1pt_btn:
                updateScoreBoard(1, TEAM_A);
                break;
            case R.id.team_a_2pt_btn:
                updateScoreBoard(2, TEAM_A);
                break;
            case R.id.team_a_3pt_btn:
                updateScoreBoard(3, TEAM_A);
                break;
            case R.id.team_b_1pt_btn:
                updateScoreBoard(1, TEAM_B);
                break;
            case R.id.team_b_2pt_btn:
                updateScoreBoard(2, TEAM_B);
                break;
            case R.id.team_b_3pt_btn:
                updateScoreBoard(3, TEAM_B);
                break;
            case R.id.reset_btn:
                resetScoreBoard();
                break;
        }
    }
    
    /**
     * Updates the score board
     * @param score The value to be added to the current score
     * @param team The team score to be updated
     */
    private void updateScoreBoard(int score, int team) {
        switch(team) {
            case TEAM_A:
                teamAScore += score;
                teamAScoreTxtView.setText(String.format("%02d", (teamAScore % 100)));
                break;
            case TEAM_B:
                teamBScore += score;
                teamBScoreTxtView.setText(String.format("%02d", (teamBScore % 100)));
                break;
        }
    }

    /**
     * Resets the score board to '00'
     */
    private void resetScoreBoard() {
        teamAScore = 0;
        teamAScoreTxtView.setText("00");
        teamBScore = 0;
        teamBScoreTxtView.setText("00");
    }
}
