package unsw.Infs3605.Mydegree;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;

public class QuizResultsActivity extends MainActivity {

    ImageView flower;
    Button bt;
    int correctCount;
    int questionCount;
    int topic;
    private int corr;
    boolean[] correctArray;
    User u = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        appBarTxt.setText("Result marked");

        Intent intent = getIntent();
        correctCount = intent.getIntExtra("KEYCORRECT", 0);
        questionCount = intent.getIntExtra("KEYTOTAL", 0);
        topic = intent.getIntExtra("TOPIC_REVIEW", -1);
        correctArray = intent.getBooleanArrayExtra("KEYCORRECTARRAY");

        TextView tv_result = findViewById(R.id.result_display_textview);
        flower = findViewById(R.id.cong);
        if(correctCount == 4){
            corr++;
            String message = "Bingo!!! Your result is " + correctCount + "/" + questionCount;
            tv_result.setText(message);
            flower.setVisibility(View.VISIBLE);
            final UserDatabaseHelper dbHelper = new UserDatabaseHelper(QuizResultsActivity.this);
            dbHelper.updatepoint(u.getUsername());

                final Dialog dialog2 = new Dialog(QuizResultsActivity.this);
                        dialog2.setContentView(R.layout.activity_quiz_attempt);
                        ImageView closeButton = (ImageView) dialog2.findViewById(R.id.closeButton);
                        dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        dialog2.show();
                        closeButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();

                            }
                        });

                        Button viewButton = (Button) dialog2.findViewById(R.id.button4);
                        viewButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(QuizResultsActivity.this,BadgesActivity.class);
                                intent.putExtra("KEY","unlock");
                                startActivity(intent);

                            }
                        });
//            }
        }else {

            String message = "Your result is " + correctCount + "/" + questionCount;
            tv_result.setText(message);
            flower.setVisibility(View.INVISIBLE);
            final UserDatabaseHelper dbHelper = new UserDatabaseHelper(QuizResultsActivity.this);
            dbHelper.updatepoint01(u.getUsername());

            if(dbHelper.getPoints(u.getUsername())==1){
                final Dialog dialog2 = new Dialog(QuizResultsActivity.this);
                dialog2.setContentView(R.layout.activity_quiz_attempt);
                ImageView closeButton = (ImageView) dialog2.findViewById(R.id.closeButton);
                dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog2.show();
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();

                    }
                });

                Button viewButton = (Button) dialog2.findViewById(R.id.button4);
                viewButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final UserDatabaseHelper dbHelper = new UserDatabaseHelper(QuizResultsActivity.this);
                        dbHelper.updatepoint01(u.getUsername());

                        Intent intent = new Intent(QuizResultsActivity.this,BadgesActivity.class);
                        intent.putExtra("KEY","unlock");
                        startActivity(intent);

                    }
                });
            }
        }

        bt= findViewById(R.id.share_btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "I have finished topic " +topic+ " quiz in the MyDegree App"+" My score is: "+correctCount + "/" + questionCount;
                String shareSub = "MyDegree is awesome!";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent,"Share using"));
            }
        });

    }

    @Override public void onBackPressed() {
        startActivity(new Intent(QuizResultsActivity.this, QuizSelectionActivity.class));
        finish();
    }

    public void toReview(View view){

        Intent intent = new Intent(this, QuizReviewActivity.class);

        intent.putExtra("KEYCORRECT", correctCount);
        intent.putExtra("KEYTOTAL", questionCount);
        intent.putExtra("TOPIC_REVIEW", topic);
        intent.putExtra("KEYCORRECTARRAY", correctArray);
        startActivity(intent);
    }
}
