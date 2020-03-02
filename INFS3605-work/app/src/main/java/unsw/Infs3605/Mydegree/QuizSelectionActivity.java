package unsw.Infs3605.Mydegree;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;

public class QuizSelectionActivity extends MainActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizzes_list);

        appBarTxt.setText("MyDegree Quizzes");

        final String[] topicHeadingLevelOneArray = {
                "Quiz 1: First Year",
                "Quiz 2: Second Year",
                "Quiz 3: Third Year",


        };

        final String[] topicHeadingLevelTwoArray = {
                "4 Questions --> ",
                "4 Questions --> ",
                "4 Questions --> ",


        };

        QuizSelectionAdapter newQuizSelectionAdapter = new QuizSelectionAdapter(this, topicHeadingLevelOneArray, topicHeadingLevelTwoArray);
        listView = (ListView) findViewById(R.id.quizzes_list);
        listView.setAdapter(newQuizSelectionAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QuizSelectionActivity.this, QuizTestActivity.class);
                intent.putExtra("TOPIC_TEST", (position + 1));
                startActivity(intent);

            }
        });

    }
}