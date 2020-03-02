package unsw.Infs3605.Mydegree;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class BadgesActivity extends MainActivity {
    ImageView badge1;
    ImageView badge2;
    ImageView badge3;
    ImageView badge4;
    ImageView badge5;
    ImageView badge6;
    ImageView badge7;
    ImageView badge8;
    ImageView badge9;
    Toast toast;
    Context mContext;
    User u = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badges);




        CourseDatabaseHelper dbHelper = new CourseDatabaseHelper(getApplicationContext());
        UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
        badge1 = findViewById(R.id.badge1);
        badge2 = findViewById(R.id.badge2);
        badge3 = findViewById(R.id.badge3);
        badge4 = findViewById(R.id.badge4);
        badge5 = findViewById(R.id.badge5);
        badge6 = findViewById(R.id.badge6);
        badge7 = findViewById(R.id.badge7);
        badge8 = findViewById(R.id.badge8);
        badge9 = findViewById(R.id.badge9);


//        badge1.setColorFilter(Color.argb(255, 255, 255, 255));
        badge2.setColorFilter(Color.argb(255, 255, 255, 255));
        badge3.setColorFilter(Color.argb(255, 255, 255, 255));

        badge4.setColorFilter(Color.argb(255, 255, 255, 255));
        badge5.setColorFilter(Color.argb(255, 255, 255, 255));
        badge6.setColorFilter(Color.argb(255, 255, 255, 255));
        badge7.setColorFilter(Color.argb(255, 255, 255, 255));
        badge8.setColorFilter(Color.argb(255, 255, 255, 255));
        badge9.setColorFilter(Color.argb(255, 255, 255, 255));


        int q=0;
        int c=0;
        int p= dbHelper.getRemainingPECourses();
        int hh = udb.getPoints(u.getUsername());
        c= 24 -(dbHelper.getRemainingCoreCourses()+dbHelper.getRemainingBusCoreCourses()+dbHelper.getRemainingPECourses()+dbHelper.getRemainingFECourses()+dbHelper.getRemainingGECourses());

        if(c>=3) {
            badge2.clearColorFilter();
        }

        if(c>=18) {
            badge3.clearColorFilter();
        }

        if(p<=0){
            badge4.clearColorFilter();
        }

        if(c>=24) {
            badge5.clearColorFilter();
        }


//        Intent iin = getIntent();
//        Bundle b = iin.getExtras();
//
//        if(b!=null){
//            badge6.clearColorFilter();
//        }

        if(hh>=1){
            badge6.clearColorFilter();
        }

        if(hh>=10){
            badge7.clearColorFilter();

        }

        if(hh>=20){
            badge8.clearColorFilter();

        }

        if(hh>=30){
            badge9.clearColorFilter();

        }


    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showbadge1Intro(View view) {
        displayToast("This is a free gift for you!");
    }

    public void showbadge2Intro(View view) {
        displayToast("This badge is for completing Year 1 Term 1 enrollment");
    }


    public void showbadge3Intro(View view) {
        displayToast("This badge is for completing Year 2 enrollment");
    }

    public void showbadge4Intro(View view) {
        displayToast("This badge is for completing 2 Prescribed Electives");
    }

    public void showbadge5Intro(View view) {
        displayToast("This badge is for completing all enrollment");
    }
    public void showbadge6Intro(View view) {
        displayToast("This badge is for attempting a quiz");
    }
    public void showbadge7Intro(View view) {
        displayToast("This badge is for reached level 1");
    }
    public void showbadge8Intro(View view) {
        displayToast("This badge is for reached level 2");
    }
    public void showbadge9Intro(View view) {
        displayToast("This badge is for reached level 3");
    }

    @Override public void onBackPressed() {
        startActivity(new Intent(BadgesActivity.this, HomepageActivity.class));
        finish();
    }
}
