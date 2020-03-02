package unsw.Infs3605.Mydegree;

import android.widget.ArrayAdapter;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LearnAdapter extends ArrayAdapter {

    private static final String TAG = "LearnAdapter";
    private final Activity context;
    private final String[] topicHeadingLevelOneArray;
    private final String[] topicHeadingLevelTwoArray;
    private final String[] topicContent;



    public LearnAdapter(Activity context, String[] topicHeadingLevelOneArray, String[] topicHeadingLevelTwoArray,
                       String[] topicContent) {

        super(context, R.layout.activity_learnlistviewrow, topicHeadingLevelOneArray);

        this.context = context;
        this.topicHeadingLevelOneArray = topicHeadingLevelOneArray;
        this.topicHeadingLevelTwoArray = topicHeadingLevelTwoArray;
        this.topicContent = topicContent;

        Log.d(TAG, "LearnAdapter: ends");

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_learnlistviewrow, null,true);


        TextView topicTV = (TextView) rowView.findViewById(R.id.single_learn_title);
        TextView line2TV = (TextView) rowView.findViewById(R.id.single_learn_subtitle);


        topicTV.setText(topicHeadingLevelOneArray[position]);
        line2TV.setText(topicHeadingLevelTwoArray[position]);

        return rowView;

    }
}
