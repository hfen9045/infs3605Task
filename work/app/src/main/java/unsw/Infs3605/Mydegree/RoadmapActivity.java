package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RoadmapActivity extends MainActivity {
    TextView y1t1;
    TextView y1t2;
    TextView y1t3;
    TextView y2t1;
    TextView y2t2;
    TextView y2t3;
    TextView y3t1;
    TextView y3t2;
    TextView y3t3;


    List<Course> courseListy1t1;
    List<Course> courseListy1t2;
    List<Course> courseListy1t3;
    List<Course> courseListy2t1;
    List<Course> courseListy2t2;
    List<Course> courseListy2t3;
    List<Course> courseListy3t1;
    List<Course> courseListy3t2;
    List<Course> courseListy3t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadmap);
        appBarTxt.setText("My Roadmap");


        y1t1 = findViewById(R.id.y1t1);
        y1t2 = findViewById(R.id.y1t2);
        y1t3 = findViewById(R.id.y1t3);

        y2t1 = findViewById(R.id.y2t1);
        y2t2 = findViewById(R.id.y2t2);
        y2t3 = findViewById(R.id.y2t3);

        y3t1 = findViewById(R.id.y3t1);
        y3t2 = findViewById(R.id.y3t2);
        y3t3 = findViewById(R.id.y3t3);


        final CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(getApplicationContext());
        courseListy1t1 = dbHelper.getAllT1Courses();
        if(courseListy1t1.size()!=0) {

            if(courseListy1t1.size()>=1){
                final String course = courseListy1t1.get(0).getCourseTitle();
                y1t1.setText(course);
            }

            if(courseListy1t1.size()>=2){
                final String course = courseListy1t1.get(0).getCourseTitle();
                final String course1 = courseListy1t1.get(1).getCourseTitle();
                y1t1.setText(course + "\n"+course1);
            }

            if(courseListy1t1.size()>=3){
                final String course = courseListy1t1.get(0).getCourseTitle();
                final String course1 = courseListy1t1.get(1).getCourseTitle();
                final String course2 = courseListy1t1.get(2).getCourseTitle();
                y1t1.setText(course+"\n"+course1+"\n"+course2);
            }
        }


        courseListy1t2 = dbHelper.getAllT2Courses();
        if(courseListy1t2.size()!=0) {

            if(courseListy1t2.size()>=1){
                final String course3 = courseListy1t2.get(0).getCourseTitle();
                y1t2.setText(course3);
            }

            if(courseListy1t2.size()>=2){
                final String course3 = courseListy1t2.get(0).getCourseTitle();
                final String course4 = courseListy1t2.get(1).getCourseTitle();
                y1t2.setText(course3 + "\n"+course4);
            }

            if(courseListy1t2.size()>=3){
                final String course3 = courseListy1t2.get(0).getCourseTitle();
                final String course4 = courseListy1t2.get(1).getCourseTitle();
                final String course5 = courseListy1t2.get(2).getCourseTitle();
                y1t2.setText(course3 + "\n"+course4+ "\n"+course5);
            }
        }

        courseListy1t3 = dbHelper.getAllT3Courses();
        if(courseListy1t3.size()!=0) {

            if(courseListy1t2.size()>=1){
                final String course6 = courseListy1t3.get(0).getCourseTitle();
                y1t3.setText(course6);
            }

            if(courseListy1t3.size()>=2){
                final String course6 = courseListy1t3.get(0).getCourseTitle();
                final String course7 = courseListy1t3.get(1).getCourseTitle();
                y1t3.setText(course6+"\n"+course7);
            }

            if(courseListy1t3.size()>=3){
                final String course6 = courseListy1t3.get(0).getCourseTitle();
                final String course7 = courseListy1t3.get(1).getCourseTitle();
                final String course8 = courseListy1t3.get(2).getCourseTitle();
                y1t3.setText(course6+"\n"+course7+"\n"+course8);
            }
        }


        courseListy2t1 = dbHelper.getAllT1Y2Courses();
        if(courseListy2t1.size()!=0) {

            if(courseListy2t1.size()>=1){
                final String course6 = courseListy2t1.get(0).getCourseTitle();
                y2t1.setText(course6);
            }

            if(courseListy2t1.size()>=2){
                final String course6 = courseListy2t1.get(0).getCourseTitle();
                final String course7 = courseListy2t1.get(1).getCourseTitle();
                y2t1.setText(course6+"\n"+course7);
            }

            if(courseListy2t1.size()>=3){
                final String course6 = courseListy2t1.get(0).getCourseTitle();
                final String course7 = courseListy2t1.get(1).getCourseTitle();
                final String course8 = courseListy2t1.get(2).getCourseTitle();
                y2t1.setText(course6+"\n"+course7+"\n"+course8);
            }
        }


        courseListy2t2 = dbHelper.getAllT2Y2Courses();

        if(courseListy2t2.size()!=0) {

            if(courseListy2t2.size()>=1){
                final String course12= courseListy2t2.get(0).getCourseTitle();
                y2t2.setText(course12);
            }

            if(courseListy2t2.size()>=2){
                final String course12= courseListy2t2.get(0).getCourseTitle();
                final String course13= courseListy2t2.get(1).getCourseTitle();
                y2t2.setText(course12+"\n"+course13);
            }

            if(courseListy2t2.size()>=3){
                final String course12= courseListy2t2.get(0).getCourseTitle();
                final String course13= courseListy2t2.get(1).getCourseTitle();
                final String course14= courseListy2t2.get(2).getCourseTitle();
                y2t2.setText(course12+"\n"+course13+"\n"+course14);
            }
        }

//
        courseListy2t3 = dbHelper.getAllT3Y2Courses();
        if(courseListy2t3.size()!=0) {

            if(courseListy2t3.size()>=1){

                final String course15= courseListy2t3.get(0).getCourseTitle();

                y2t3.setText(course15);
            }

            if(courseListy2t3.size()>=2){

                final String course15= courseListy2t3.get(0).getCourseTitle();
                final String course16= courseListy2t3.get(1).getCourseTitle();

                y2t3.setText(course15+"\n"+course16);
            }

            if(courseListy2t3.size()>=3){
                final String course15= courseListy2t3.get(0).getCourseTitle();
                final String course16= courseListy2t3.get(1).getCourseTitle();
                final String course17= courseListy2t3.get(2).getCourseTitle();
                y2t3.setText(course15+"\n"+course16+"\n"+course17);
            }
        }

        courseListy3t1 = dbHelper.getAllT1Y3Courses();
        if(courseListy3t1.size()!=0) {

            if(courseListy3t1.size()>=1){
                final String course18= courseListy3t1.get(0).getCourseTitle();

                y3t1.setText(course18);
            }

            if(courseListy3t1.size()>=2){
                final String course18= courseListy3t1.get(0).getCourseTitle();
                final String course19= courseListy3t1.get(1).getCourseTitle();

                y3t1.setText(course18+"\n"+course19);
            }

            if(courseListy3t1.size()>=3){
                final String course18= courseListy3t1.get(0).getCourseTitle();
                final String course19= courseListy3t1.get(1).getCourseTitle();
                final String course20= courseListy3t1.get(2).getCourseTitle();
                y3t1.setText(course18+"\n"+course19+"\n"+course20);
            }
        }


        courseListy3t2 = dbHelper.getAllT2Y3Courses();
        if(courseListy3t2.size()!=0) {

            if(courseListy3t2.size()>=1){
                final String course21= courseListy3t2.get(0).getCourseTitle();

                y3t2.setText(course21);
            }

            if(courseListy3t2.size()>=2){
                final String course21= courseListy3t2.get(0).getCourseTitle();
                final String course22= courseListy3t2.get(1).getCourseTitle();

                y3t2.setText(course21+"\n"+course22);
            }

            if(courseListy3t2.size()>=3){
                final String course21= courseListy3t2.get(0).getCourseTitle();
                final String course22= courseListy3t2.get(1).getCourseTitle();
                final String course23= courseListy3t2.get(2).getCourseTitle();
                y3t2.setText(course21+"\n"+course22+"\n"+course23);
            }
        }



        courseListy3t3 = dbHelper.getAllT3Y3Courses();
        if(courseListy3t3.size()!=0) {

            if(courseListy3t3.size()>=1){
                final String course24= courseListy3t3.get(0).getCourseTitle();
                y3t3.setText(course24);
            }

            if(courseListy3t3.size()>=2){
                final String course24= courseListy3t3.get(0).getCourseTitle();
                final String course25= courseListy3t3.get(1).getCourseTitle();
                y3t3.setText(course24+"\n"+course25);
            }

            if(courseListy3t3.size()>=3){
                final String course24= courseListy3t3.get(0).getCourseTitle();
                final String course25= courseListy3t3.get(1).getCourseTitle();
                final String course26= courseListy3t3.get(2).getCourseTitle();
                y3t3.setText(course24+"\n"+course25+"\n"+course26);
            }
        }









//        StringBuilder builder = new StringBuilder();
//        for (courseListy1t1) {
//            builder.append(List : details + "\n");
//        }
//        custName.setText(builder.toString());
//


//        for (int i=0; i<courseListy1t1.size();i++){
//            y1t1.append(courseListy1t1.get(i).getCourseTitle());
//            y1t1.append("\n");
//        }






    }




    @Override public void onBackPressed() {
        startActivity(new Intent(RoadmapActivity.this, ManagementActivity.class));
        finish();
    }
}
