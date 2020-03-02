package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;
import com.app.hubert.guide.listener.OnPageChangedListener;
import com.app.hubert.guide.model.GuidePage;

//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
//private DrawerLayout drawer;
//        Dialog dialog;
//
//
//@Override
//protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        drawer = findViewById(R.id.drawer_layout);
//        NavigationView navigationView = findViewById(R.id.navigation_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, 0, 0);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        if (savedInstanceState == null) {
//            startActivity(new Intent(MainActivity.this, HomepageActivity.class));
//            navigationView.setCheckedItem(R.id.nav_home);
//        }
//        }
//
//@Override
//public boolean onNavigationItemSelected(MenuItem menuItem) {
//    switch (menuItem.getItemId()) {
//        case R.id.nav_home:
//            startActivity(new Intent(MainActivity.this, HomepageActivity.class));
//            finish();
//            break;
//
//        case R.id.nav_topic:
//            startActivity(new Intent(MainActivity.this, LearnActivity.class));
//            finish();
//            break;
//
//        case R.id.nav_video:
//            startActivity(new Intent(MainActivity.this, VideoActivity.class));
//            finish();
//            break;
//
//        case R.id.nav_quiz:
//            startActivity(new Intent(MainActivity.this, QuizSelectionActivity.class));
//            finish();
//            break;
//
//
//
//        case R.id.nav_search:
//            startActivity(new Intent(MainActivity.this, NotesActivity.class));
//            finish();
//            break;
//
//        default:
//            startActivity(new Intent(MainActivity.this, HomeActivity.class));
//            finish();
//    }
//
//
//    if (menuItem.isChecked()) {
//        menuItem.setChecked(false);
//    } else {
//        menuItem.setChecked(true);
//    }
//    menuItem.setChecked(true);
//    return true;
//}
//
//@Override
//public void onBackPressed() {
//        if(drawer.isDrawerOpen(GravityCompat.START)){
//        drawer.closeDrawer(GravityCompat.START);
//        }else{
//        super.onBackPressed();
//        }
//        }
//
//
//        }
//old version of the navigation part
public class MainActivity extends AppCompatActivity {

    public static final String TAG_N = "Navi";
    public TextView appBarTxt;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private float lastTranslate = 0.0f;
    private ImageView imgLeftToolbar;
    private boolean isOpenOrClose = false;
    private ActionBarDrawerToggle drawerToggle;
    private ImageView back;


    User u = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
        finish();


    }



    @Override
    public void setContentView(int layout) {

        View parentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
        FrameLayout frame = (FrameLayout) parentView.findViewById(R.id.frame);
        getLayoutInflater().inflate(layout, frame, true);
        super.setContentView(parentView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarTxt = (TextView) findViewById(R.id.toolbar_title);
        imgLeftToolbar = (ImageView) findViewById(R.id.toolbar_menu_img);
        back = findViewById(R.id.backk);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



        //navigation user data load
        UserDatabaseHelper udb = new UserDatabaseHelper(getApplicationContext());
//        icon = findViewById(R.id.navicon);


//        icon = (ImageView) findViewById(R.id.navicon);
//        icon.setImageResource(R.drawable.unicorn);

        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setUpNavigationView();

        View hView =  navigationView.getHeaderView(0);
        ImageView icon = (ImageView) hView.findViewById(R.id.navicon);
        TextView uname = (TextView) hView.findViewById(R.id.navname);
        TextView exp =(TextView) hView.findViewById(R.id.navexp);
        TextView levl = (TextView) hView.findViewById(R.id.navlv);
        ProgressBar epgr = (ProgressBar)hView.findViewById(R.id.navpg);
        ImageView lv = (ImageView)hView.findViewById(R.id.navlvic);
        String na = u.getUsername();


        Integer i = udb.getPoints(u.getUsername());
        Integer i1 = i-10;
        Integer i2 = i-20;
        Integer i3 = i-30;
        Integer i4 = i-40;
        if(udb.getIcon(u.getUsername())==0){
            icon.setImageResource(R.drawable.wanted);


        }
        if(udb.getIcon(u.getUsername())==1){
            icon.setImageResource(R.drawable.pirate);


        }
        if(udb.getIcon(u.getUsername())==2){
            icon.setImageResource(R.drawable.monkey);


        }
        if(udb.getIcon(u.getUsername())==3){
            icon.setImageResource(R.drawable.kitty);

        }
        if(udb.getIcon(u.getUsername())==4){
            icon.setImageResource(R.drawable.parrot);

        }
        if(udb.getIcon(u.getUsername())==5){
            icon.setImageResource(R.drawable.unicorn);

        }

        if(i>=0){
            uname.setText("Hi, "+na);
            levl.setText("Level 1");
            exp.setText(i.toString() +"/10");
            epgr.setProgress(i*10);
            lv.setImageResource(R.drawable.lv1);
        }

        if(i>=10){
            levl.setText("Level 2");
            exp.setText(i1+"/10");
            epgr.setProgress(i1*10);
            lv.setImageResource(R.drawable.lv2);
        }

        if(i>=20){
            levl.setText("Level 3");
            exp.setText(i2+"/10");
            epgr.setProgress(i2*10);
            lv.setImageResource(R.drawable.lv3);
        }

        if(i>=30){
            levl.setText("Level 4");
            exp.setText(i3.toString()+"/10");
            epgr.setProgress(i3*10);
            lv.setImageResource(R.drawable.lv4);
        }

        if(i>=40){
            levl.setText("Level ∞");
            exp.setText(i4.toString()+"/∞");
            epgr.setProgress(100);
            lv.setImageResource(R.drawable.lva);

        }




        Log.i(TAG_N, "Navigation views set.");
        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer) {
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (drawerView.getWidth() * slideOffset);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    findViewById(R.id.navigaion_open_layout).setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0);
                    anim.setFillAfter(true);
                    findViewById(R.id.navigaion_open_layout).startAnimation(anim);
                    lastTranslate = moveFactor;

                }
            }
        };



        imgLeftToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpenOrClose)
                    drawer.closeDrawers();
                else
                    drawer.openDrawer(GravityCompat.START);


            }
        });


    }


    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int i = menuItem.getItemId();
                if (i == R.id.nav_home) {
                    startActivity(new Intent(MainActivity.this, HomepageActivity.class));
                    finish();
                } else if (i == R.id.nav_profile) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                    finish();
                } else if (i == R.id.nav_mgmt) {
                    startActivity(new Intent(MainActivity.this, ManagementActivity.class));
                    finish();
                } else if (i == R.id.nav_topic) {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();

//                    case R.id.nav_video:
//                        startActivity(new Intent(MainActivity.this, VideoActivity.class));
//                        finish();
//                        break;
                } else if (i == R.id.nav_quiz) {
                    startActivity(new Intent(MainActivity.this, QuizSelectionActivity.class));
                    finish();
                } else if (i == R.id.nav_badges) {
                    startActivity(new Intent(MainActivity.this, BadgesActivity.class));
                    finish();
                } else if (i == R.id.nav_search) {
                    startActivity(new Intent(MainActivity.this, NotesActivity.class));
                    finish();
                } else if (i == R.id.nav_logout) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    finish();
                }
                Log.i(TAG_N, "Drawer item intents set.");

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                return true;
            }
        });




    }


}
