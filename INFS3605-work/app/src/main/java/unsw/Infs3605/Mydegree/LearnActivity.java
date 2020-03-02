package unsw.Infs3605.Mydegree;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class LearnActivity extends MainActivity {

    ListView listView;
    private static final String TAG = "learn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        appBarTxt.setText("Learning Point");

        Log.d(TAG, "Learning: starts");


        final String[] topictitleArray = {
                "Tutorial 1",
                "Tutorial 2",
                "Tutorial 3",
                "Tutorial 4",
                "Tutorial 5",
        };


        final String[] topicHeadingLevelOneArray = {
                "Tutorial 1: How to Graduate",
                "Tutorial 2: How to Manage My Degree",
                "Tutorial 3: How to Take Quiz",
                "Tutorial 4: How to edit My Profile",
                "Tutorial 5: How to gain Exp & Level up for your account",


        };

        final String[] topicHeadingLevelTwoArray = {
                "Learning about progression",
                "Making your own personalised timetable",
                "Reviewing your knowledge of progression",
                "Viewing badges and changing your profile picture",
                "Unlocking badges",

        };

        final String[] topicContent = {
                // Tutorial 1
                "The Bachelor of Information Systems Degree consists of 24 Courses (144 Courses).\n" +

                        "These courses are made up of:\n" +

                        "1. 4 Business Core Courses (24UOC)\n" +
                        "2. 12 Information Systems Core Courses (72UOC)\n" +
                        "3. 2 Level 2 and 3 Prescribed Information Systems Electives (12 UOC)\n" +
                        "4. 4 Free Elective Courses (24UOC)\n" +
                        "5. 2 General Education Courses (12UOC) \n" +
                        " \n" +
                        "Additional Information:\n" +
                        "1. No more than 10 level 1 courses (60 UOC) will be counted in your degree\n" +
                        "2. Many Level 2 and 3 courses have prerequisite courses which much be completed beforehand\n" +
                        "4. You can study up to 3 courses per term, if you wish to do more courses in a term, you will have to apply for term overloading.\n" +
                        "3. A 'normal' schedule consists of students selecting 8 courses per term. Students can expect to graduate in 3 years." +


                        "\n" +
                        "To view specific course details, head over to the Course List page which can be found in Home\n",
                        "\n" +




                //  Tutorial 2
                "Making your own personalised timetable:\n" +

                        "\n" +
                        "1. Head over to the Manage My Degree Section via the Homepage or  the Menubar on the top left\n" +

                        "2.  Select Year 1 (Note: You will be unable to access further years yet)\n" +
                        "3.  Starting at Term 1, select a course you wish to complete for that specific term by pressing the course.\n" +
                        "4.  A pop up giving a brief course description will appear alongside a 'Add Course' button which you can select\n" +
                        "5.  If the course is unavailble due to prerequisite or term offering problems, an error message will replace the pop up."+
                        "6.  Continue selecting courses until you have up to 3 courses\n" +
                        "7.  If you wish to remove a course, press and hold the specific course and press yes when prompted. \n "+
                        "8.  An enroll button will appear under the 'Selected Courses' section. Note if you do not see it, then refresh the page by swiping between terms.\n" +
                        "9.  You will receive a pop up confirming the courses have been successfully added. \n" +
                        "10. Continue on for terms 2 and 3.\n" +
                        "11. Once you have completed Year 1, Year 2 will become unlocked. You can continue until you plan your entire degree.\n "+
                        "12. Congratulations! You have successfully managed your degree" +



                        "\n" +
                        "If you wish to simplify how to manage your degree, an example progression template is provided in the homepage which has been designed by experienced INFS Students. \n" ,



                // Tutorial 3
                "Taking a quiz:\n" +

                        "\n" +
                        "1. To test your knowledge of progression, 3 quizzes have been provided.\n" +

                        "2. The quizzes can be accessed via the Learning Section on the HomePage, or directly through the Menu Bar\n" +
                        "3. There are 3 quizzes which are available, and are separated into 1st, 2nd, and 3rd year questions \n" +
                        "4. The quizzes come in various multiple choice and true or false formats. Mark your answer by selecting the correct choice\n" +
                        "5. When you have answered all the questions, press the yellow arrow which will reveal your score.\n" +
                        "6. By pressing Review, you can see in-depth explanations for each question\n" +
                        "7. You can also share your results via Messages or Email by pressing Share.\n" ,






                //Tutorial 4
                "Your Profile:\n" +

                        "\n" +
                        "Your profile can be accessed via the Menu Bar on the top left of the app.\n" +

                        "1. You will be prompted to a screen containing your username, level, and icon. \n" +
                        "2. To change your icon click any of the 6 icons below. \n" +

                "\n"+
                        "My Badges:\n"+
                        "1. You can also view your collected badges by clicking Badges in the Menu Bar\n "+
                        "2. Here, you can view your badges, and also view badges which are yet to be unlocked!"
                     ,



                // Tutorial 5
                "Gaining Exp and Levelling Up:\n" +

                        "\n" +
                        "Level up your account and unlock various badges!\n"
                        +
                        "For each level, you must gain 10 exp to level up\n" +
                        "\n" +
                        "\n" +
                        "There are many ways in which you can receive experience points and level up your profile:\n" +

                        "1. By attempting a quiz, you can receive 1 exp.\n" +
                        "2. By receiving full marks in a quiz, you can receive 10 exp.\n" +
                        //Double check
                        "\n"+"\n"
                        + "There are also specific challenges that are available for unlocking badges, they can be found on the Badges Section."
                        ,
        };

        final String[] youtubeVideoId = {
                "T3234zeQWzM",
                "KU604hRSrxI",
                "CUnPmY7CfpU",
                "i-08jn0VP-A",
                "SWPDYhtX96Y",

        };

        LearnAdapter newLearnAdapter = new LearnAdapter(this, topicHeadingLevelOneArray, topicHeadingLevelTwoArray, topicContent);
        listView = (ListView) findViewById(R.id.learn_listview);
        listView.setAdapter(newLearnAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LearnActivity.this, LearnDetail.class);
                String message = topicHeadingLevelOneArray[position];
                String message2 = topicContent[position];
                String message3 = youtubeVideoId[position];

                String meesage4 = topictitleArray[position];


                intent.putExtra("topic", message);
                intent.putExtra("content", message2);
                intent.putExtra("videoid", message3);

                intent.putExtra("title",meesage4);

                startActivity(intent);

            }
        });
        Log.d(TAG, "Create end");

    }

    @Override public void onBackPressed() {
        startActivity(new Intent(LearnActivity.this, HomeActivity.class));
        finish();
    }
}
