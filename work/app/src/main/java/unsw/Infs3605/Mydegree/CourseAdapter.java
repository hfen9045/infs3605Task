package unsw.Infs3605.Mydegree;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CViewHolder> {
    private ArrayList<CourseArrayList> mcourse;
    private RecyclerViewClickListener mlistener;

    public CourseAdapter(ArrayList<CourseArrayList> course, RecyclerViewClickListener listener) {
        mcourse = course;
        mlistener = listener;
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class CViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView courseid, coursename;
        private RecyclerViewClickListener mListener;

        public CViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            courseid = v.findViewById(R.id.courseID);
            coursename = v.findViewById(R.id.courseName);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public CourseAdapter.CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_list_row, parent, false);
        return new CViewHolder(v, mlistener);
    }

    @Override
    public void onBindViewHolder(CViewHolder holder, int position) {
        CourseArrayList courseA = mcourse.get(position);
        holder.courseid.setText(courseA.getCourseid());
        holder.coursename.setText(courseA.getCoursename());

    }

    @Override
    public int getItemCount() {
        return mcourse.size();
    }

}
