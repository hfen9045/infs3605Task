package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CourseDetail extends MainActivity {

    private TextView mID;
    private TextView mName;
    private TextView mFaculty;
    private TextView mDescription;
    private TextView mAvailabilty;
    private TextView mAssessment;
    private TextView mPrerequisite;
    private CourseArrayList mCourses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Course Detail");
        setContentView(R.layout.activity_course_detail);
        mID = findViewById(R.id.ID);
        mName = findViewById(R.id.Name);
        mFaculty = findViewById(R.id.Faculty);
        mDescription = findViewById(R.id.Description);
        mAvailabilty = findViewById(R.id.Availabilty);
        mAssessment = findViewById(R.id.Assessment);
        mPrerequisite = findViewById(R.id.Prerequisite);


        Intent intent = getIntent();
        int position = intent.getIntExtra(CoursePage.EXTRA_MESSAGE, 0);
        mCourses = CourseArrayList.getDummyCourses().get(position);
        mID.setText(mCourses.getCourseid());
        mName.setText(mCourses.getCoursename());
        mFaculty.setText(mCourses.getCoursefaculty());
        mDescription.setText(mCourses.getCoursedescription());
        mAvailabilty.setText("Availability: \n" + mCourses.getTermavavailability());
        mAssessment.setText("Assessment Structure: \n" + mCourses.getAssessment());
        mPrerequisite.setText("Pre-requisite(s): \n" + mCourses.getPrereq());


    }
    @Override public void onBackPressed() {
        startActivity(new Intent(CourseDetail.this, CoursePage.class));
        finish();
    }
}