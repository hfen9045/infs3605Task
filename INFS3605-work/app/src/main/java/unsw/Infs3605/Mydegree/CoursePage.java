package unsw.Infs3605.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CoursePage extends MainActivity {
    public static final String EXTRA_MESSAGE = "MyDegree";

    private RecyclerView view;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        this.setTitle("Course List");

        view = findViewById(R.id.list);
        view.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        view.setLayoutManager(manager);
        CourseAdapter.RecyclerViewClickListener listener = new CourseAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchDetailActivity(position);
            }
        };
        adapter = new CourseAdapter(CourseArrayList.getDummyCourses(), listener);
        view.setAdapter(adapter);

    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, CourseDetail.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

    @Override public void onBackPressed() {
        startActivity(new Intent(CoursePage.this, HomepageActivity.class));
        finish();
    }
}
