package unsw.Infs3605.Mydegree;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ManagementActivity extends MainActivity {
    Dialog dialog;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage1page);
        appBarTxt.setText("Manage My Degree");

        Button buttonY1 = findViewById(R.id.button);
        Button buttonY2 = findViewById(R.id.button2);
        Button buttonY3 = findViewById(R.id.button3);
        Button buttonRM = findViewById(R.id.button5);



        buttonY1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementActivity.this, year1_mgmtActivity.class);
                startActivity(intent);
            }
        });

        buttonY2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(ManagementActivity.this);
                int remainingCore = dbHelper.getRemainingCoreCourses();
                int remainingBC = dbHelper.getRemainingBusCoreCourses();
                int remainingFElective = dbHelper.getRemainingFECourses();
                int remainingPE = dbHelper.getRemainingPECourses();
                int remainingGen = dbHelper.getRemainingGECourses();
                int total = remainingCore + remainingFElective + remainingGen + remainingBC + remainingPE;

                if (total <= 15) {
                    Intent intent = new Intent(ManagementActivity.this, year2_mgmtActivity.class);
                    startActivity(intent);
                }

                else{

                    dialog = new Dialog(ManagementActivity.this);
                    dialog.setContentView(R.layout.activity_year2_erro);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });

//                    Toast.makeText(ManagementActivity.this, "This stage is locked. Please complete your Year 1 enrolment."+"remaining course: "+total, Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonY3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(ManagementActivity.this);
                int remainingCore = dbHelper.getRemainingCoreCourses();
                int remainingBC = dbHelper.getRemainingBusCoreCourses();
                int remainingFElective = dbHelper.getRemainingFECourses();
                int remainingPE = dbHelper.getRemainingPECourses();
                int remainingGen = dbHelper.getRemainingGECourses();
                int total = remainingCore + remainingFElective + remainingGen + remainingBC + remainingPE;

                if (total <= 6) {
                    Intent intent = new Intent(ManagementActivity.this, year3_mgmtActivity.class);
                    startActivity(intent);
                }

                else{

                    dialog = new Dialog(ManagementActivity.this);
                    dialog.setContentView(R.layout.activity_year3_erro);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });

//                    Toast.makeText(ManagementActivity.this, "This stage is locked. Please complete your Year 2 enrolment."+"remaining course: "+total, Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonRM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManagementActivity.this, RoadmapActivity.class);
                startActivity(intent);
            }
        });
//
//        buttonQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, QuizSelectionActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    @Override public void onBackPressed() {
        startActivity(new Intent(ManagementActivity.this, HomepageActivity.class));
        finish();
    }
}
