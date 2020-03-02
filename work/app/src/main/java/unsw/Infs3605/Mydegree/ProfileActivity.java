package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends MainActivity {
    TextView uname;
    TextView point;
    TextView levl;
    ImageView imgl;
    User u = new User();

    ImageView ico;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;

    ProgressBar pgr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        appBarTxt.setText("My Profile");

        uname = findViewById(R.id.username);
        point = findViewById(R.id.points);
        levl = findViewById(R.id.level);
        imgl = findViewById(R.id.lvim);
        pgr = (ProgressBar) findViewById(R.id.progressBar);


        b1 = findViewById(R.id.icon1);
        b2 = findViewById(R.id.icon2);
        b3 = findViewById(R.id.icon3);
        b4 = findViewById(R.id.icon4);
        b5 = findViewById(R.id.icon5);
        b6 = findViewById(R.id.icon6);
        ico = findViewById(R.id.imageView7);

//        Button de = findViewById(R.id.debug);

        UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());

        String na = u.getUsername();
        Integer i = udb.getPoints(u.getUsername());
        Integer i1 = i-10;
        Integer i2 = i-20;
        Integer i3 = i-30;
        Integer i4 = i-40;


        if(udb.getIcon(u.getUsername())==0){
            ico.setImageResource(R.drawable.wanted);
            Toast.makeText(getApplicationContext(), "rustle....",
                    Toast.LENGTH_SHORT).show();

        }
        if(udb.getIcon(u.getUsername())==1){
            ico.setImageResource(R.drawable.pirate);
            Toast.makeText(getApplicationContext(), "Aye, aye...",
                    Toast.LENGTH_SHORT).show();

        }
        if(udb.getIcon(u.getUsername())==2){
            ico.setImageResource(R.drawable.monkey);
            Toast.makeText(getApplicationContext(), "hoo hoo hoo, oo oo",
                    Toast.LENGTH_SHORT).show();

        }
        if(udb.getIcon(u.getUsername())==3){
            ico.setImageResource(R.drawable.kitty);
            Toast.makeText(getApplicationContext(), "Meow",
                    Toast.LENGTH_SHORT).show();
        }
        if(udb.getIcon(u.getUsername())==4){
            ico.setImageResource(R.drawable.parrot);
            Toast.makeText(getApplicationContext(), "Captain, Captain",
                    Toast.LENGTH_SHORT).show();
        }
        if(udb.getIcon(u.getUsername())==5){
            ico.setImageResource(R.drawable.unicorn);
            Toast.makeText(getApplicationContext(), "Do you want to see rainbow?",
                    Toast.LENGTH_SHORT).show();
        }



        if(i>=0){
            uname.setText("Hi, "+na);
            levl.setText("Level 1");
            point.setText(i.toString() +"/10");
            imgl.setImageResource(R.drawable.lv1);
            pgr.setProgress(i*10);
        }

        if(i>=10){
            levl.setText("Level 2");
            point.setText(i1+"/10");
            imgl.setImageResource(R.drawable.lv2);
            pgr.setProgress(i1*10);
        }

        if(i>=20){
            levl.setText("Level 3");
            point.setText(i2+"/10");
            imgl.setImageResource(R.drawable.lv3);
            pgr.setProgress(i2*10);
        }

        if(i>=30){
            levl.setText("Level 4");
            point.setText(i3.toString()+"/10");
            imgl.setImageResource(R.drawable.lv4);
            pgr.setProgress(i3*10);
        }

        if(i>=40){
            levl.setText("Level ∞");
            point.setText(i4.toString()+"/∞");
            imgl.setImageResource(R.drawable.lva);
            pgr.setProgress(100);

        }

//        uname.setText(u.getUsername());
//        point.setText(udb.getPoints(u.getUsername()));
//        de.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
//                Toast.makeText(getApplicationContext(), "The icon value: "+udb.getIcon(u.getUsername()),
//                        Toast.LENGTH_SHORT).show();
//            }
//        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
                ico.setImageResource(R.drawable.pirate);
                udb.updateicon1(u.getUsername());

                Toast.makeText(getApplicationContext(), "Aye, aye...",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
                ico.setImageResource(R.drawable.monkey);
                udb.updateicon2(u.getUsername());

                Toast.makeText(getApplicationContext(), "hoo hoo hoo, oo oo",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
                ico.setImageResource(R.drawable.kitty);
                udb.updateicon3(u.getUsername());

                Toast.makeText(getApplicationContext(), "Meow",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
                ico.setImageResource(R.drawable.parrot);
                udb.updateicon4(u.getUsername());

                Toast.makeText(getApplicationContext(), "Captain, Captain",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
                ico.setImageResource(R.drawable.unicorn);
                udb.updateicon5(u.getUsername());

                Toast.makeText(getApplicationContext(), "Do you want to see rainbow?",
                        Toast.LENGTH_SHORT).show();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
                ico.setImageResource(R.drawable.wanted);
                udb.updateicon6(u.getUsername());

                Toast.makeText(getApplicationContext(), "rustle....",
                        Toast.LENGTH_SHORT).show();
            }
        });




    }


    @Override public void onBackPressed() {
        startActivity(new Intent(ProfileActivity.this, HomepageActivity.class));
        finish();
    }
}
