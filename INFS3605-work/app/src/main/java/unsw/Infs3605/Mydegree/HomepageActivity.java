package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;
import com.app.hubert.guide.listener.OnPageChangedListener;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.app.hubert.guide.model.RelativeGuide;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class HomepageActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        appBarTxt.setText("Home");


        ImageButton buttonlearn = findViewById(R.id.learn_btn);
        ImageButton buttonmgmt = findViewById(R.id.mg_btn);
        ImageButton buttoncourses = findViewById(R.id.course_btn);
        ImageButton buttontemplete = findViewById(R.id.df_btn);



        buttonlearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        buttonmgmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ManageFragment()).commit();


                Intent intent = new Intent(HomepageActivity.this, ManagementActivity.class);
                startActivity(intent);
            }
        });
            buttoncourses.setOnClickListener(new View.OnClickListener() {
                   @Override
                    public void onClick(View view) {
                    Intent intent = new Intent(HomepageActivity.this, CoursePage.class);
                    startActivity(intent);
                }
       });

        buttontemplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, DefaultTempleteActivity.class);
                startActivity(intent);
            }
        });



        Animation enterAnimation = new AlphaAnimation(0f, 1f);
        enterAnimation.setDuration(600);
        enterAnimation.setFillAfter(true);

        Animation exitAnimation = new AlphaAnimation(1f, 0f);
        exitAnimation.setDuration(600);
        exitAnimation.setFillAfter(true);

        NewbieGuide.with(this)
                .setLabel("guide1")
//                .alwaysShow(true)
                .setShowCounts(1)
                .setOnPageChangedListener(new OnPageChangedListener() {
                    @Override
                    public void onPageChanged(int page) {

                         }
                })
                .addGuidePage(
                        GuidePage.newInstance()

                                .setLayoutRes(R.layout.view_guide_start)

                                .setOnLayoutInflatedListener(new OnLayoutInflatedListener() {
                                    @Override
                                    public void onLayoutInflated(View view, Controller controller) {

                                        ;
                                    }
                                })
                                .setEnterAnimation(enterAnimation)
                                .setExitAnimation(exitAnimation)
                )
                .addGuidePage(
                        GuidePage.newInstance()
                                .addHighLight(buttoncourses)
                                .setLayoutRes(R.layout.view_guide_simple)
                                .setEverywhereCancelable(true)
                                .setEnterAnimation(enterAnimation)
                                .setExitAnimation(exitAnimation)
                )

                .addGuidePage(
                        GuidePage.newInstance()
                                .addHighLight(buttonmgmt)
                                .setLayoutRes(R.layout.view_guide_manage)
                                .setEverywhereCancelable(true)
                                .setEnterAnimation(enterAnimation)
                                .setExitAnimation(exitAnimation)
                )



                .addGuidePage(
                        GuidePage.newInstance()
                                .addHighLight(buttonlearn)
                                .setLayoutRes(R.layout.view_guide_learning)
                                .setEverywhereCancelable(true)
                                .setEnterAnimation(enterAnimation)
                                .setExitAnimation(exitAnimation)


                )
                .addGuidePage(
                        GuidePage.newInstance()
                                .addHighLight(buttontemplete)
                                .setLayoutRes(R.layout.view_guide_template)
                                .setEverywhereCancelable(true)
                                .setEnterAnimation(enterAnimation)
                                .setExitAnimation(exitAnimation)

                )

                .addGuidePage(
                        GuidePage.newInstance()

                                .setLayoutRes(R.layout.view_guide_navi)
                                .setEverywhereCancelable(true)
                                .setEnterAnimation(enterAnimation)
                                .setExitAnimation(exitAnimation)

                )



                .show();













    }
    @Override public void onBackPressed() {
        startActivity(new Intent(HomepageActivity.this, HomepageActivity.class));
        finish();
    }

}
