package unsw.Infs3605.Mydegree;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class year1_RecyclerViewAdapter extends RecyclerView.Adapter<year1_RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Course> courseList;
    Dialog dialog;
    Toast toast;
    CourseDatabaseHelper dbHelper;

    List<String> t2Avail;
    List<String> t2Unavail;
    List<String> t3Avail;
    List<String> t3Unavail;

    public year1_RecyclerViewAdapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.courseList = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.activity_cardview_course, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;


    }
    public void insertData(List<Course> insertList){
        MyDiffUtilCallback diffUtilCallback = new MyDiffUtilCallback(courseList,insertList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        courseList.addAll(insertList);
        diffResult.dispatchUpdatesTo(this);
    }

    public void updateData(List<Course> newList){
        MyDiffUtilCallback diffUtilCallback = new MyDiffUtilCallback(courseList,newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilCallback);

        courseList.clear();
        courseList.addAll(newList);
        diffResult.dispatchUpdatesTo(this);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        dbHelper = new CourseDatabaseHelper(mContext);
        Course course = courseList.get(position);
        holder.courseTitle.setText(course.getCourseTitle());




        holder.cardview.setOnLongClickListener(new AdapterView.OnLongClickListener() {
            final String course = courseList.get(position).getCourseTitle();


            @Override
            public boolean onLongClick(View view) {


                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);

                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setTitle("Are you sure?");
                alertDialog.setMessage("Do you want to Remove this course?");


                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.updateIsNotCompleted(course);
                        if(dbHelper.getIsCompleted("ECON1203") == 0){
                            dbHelper.updatePrereq("MATH1041");
                            dbHelper.eitherenable("MATCH1041");
                        }
                        if(dbHelper.getIsCompleted("MATH1041") == 0){
                            dbHelper.updatePrereq("ECON1203");
                            dbHelper.eitherenable("ECON1203");
                        }
                        if (dbHelper.getIsCompleted("ACCT1511") == 0){
                            dbHelper.updatePrereq("ECON1101");
                            dbHelper.eitherenable("ECON1101");
                        }if (dbHelper.getIsCompleted("ECON1101") == 0){
                            dbHelper.updatePrereq("ACCT1511");
                            dbHelper.eitherenable("ACCT1511");
                        }
                        year1_Term1.adapter4.notifyItemChanged(holder.getAdapterPosition());






                    }
                });
                alertDialog.setNegativeButton("No", null);
                alertDialog.show();

                return true;
            }

        });


        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (courseList.get(position).getIsEnabled() == 1) {
                    final int tabNumber = year1_mgmtActivity.getTabNumber();
                    //toast.makeText(mContext,"Y1 Tab No: " +tabNumber,Toast.LENGTH_SHORT).show();
                    dialog = new Dialog(mContext);
                    dialog.setContentView(R.layout.activity_course_clicked);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    final TextView courseTitle = (TextView) dialog.findViewById(R.id.courseTitle);
                    TextView courseDescription = (TextView) dialog.findViewById(R.id.courseDescription);
                    TextView assessmentStructure = (TextView) dialog.findViewById(R.id.assessmentStructure);
                    final String course = courseList.get(position).getCourseTitle();
                    courseTitle.setText(course);
                    courseDescription.setText(courseList.get(position).getCourseDescription());
                    assessmentStructure.setText(courseList.get(position).getAssessmentStructure());
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();


                    Button addButton = (Button) dialog.findViewById(R.id.addButton);
                    addButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick (View v) {
                            int tabNumber = year1_mgmtActivity.getTabNumber();
                            dbHelper.updateIsCompleted(course);
                            if (tabNumber == 0){
                                String termSelected = "T1";
                                dbHelper.updateTerm(course,termSelected);

//                                year1_Term1.adapter.updateData(courseList);
//                                year1_Term1.adapter2.updateData(courseList);
//                                year1_Term1.adapter3.updateData(courseList);
//                                year1_Term1.adapter4.updateData(courseList);
//                                year1_Term1.adapter5.updateData(courseList);
//                                year1_Term1.adapter6.updateData(courseList);

                                year1_Term1.adapter.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term1.adapter2.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term1.adapter3.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term1.adapter4.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term1.adapter5.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term1.adapter6.notifyItemChanged(holder.getAdapterPosition());

//                                year1_Term1.adapter.notifyDataSetChanged();
//                                year1_Term1.adapter2.notifyDataSetChanged();
//                                year1_Term1.adapter3.notifyDataSetChanged();
//                                year1_Term1.adapter4.notifyDataSetChanged();
//                                year1_Term1.adapter5.notifyDataSetChanged();
//                                year1_Term1.adapter6.notifyDataSetChanged();
                                if (dbHelper.getIsCompleted("ECON1203") == 1) {
                                    dbHelper.eitherPrereq("MATH1041");
                                    dbHelper.eitherdisable("MATH1041");
                                }

                                if (dbHelper.getIsCompleted("MATH1041") == 1) {
                                    dbHelper.eitherPrereq("ECON1203");
                                    dbHelper.eitherdisable("ECON1203");
                                }

                                if (dbHelper.getIsCompleted("ACCT1511") == 1) {
                                    dbHelper.eitherPrereq("ECON1101");
                                    dbHelper.eitherdisable("ECON1101");
                                }

                                if (dbHelper.getIsCompleted("ECON1101") == 1) {
                                    dbHelper.eitherPrereq("ACCT1511");
                                    dbHelper.eitherdisable("ACCT1511");
                                }




                                Fragment fragment = (Fragment) ((FragmentActivity) mContext).getSupportFragmentManager().getFragments().get(0);
                                FragmentTransaction fragmentTransaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.detach(fragment);
                                fragmentTransaction.attach(fragment);
                                fragmentTransaction.commit();

//                                toast.makeText(mContext,"Tab No: " +tabNumber,Toast.LENGTH_SHORT).show();

                            }else if (tabNumber == 1){

                                String termSelected = "T2";
                                dbHelper.updateTerm(course,termSelected);

//                                year1_Term2.adapter.updateData(courseList);
//                                year1_Term2.adapter2.updateData(courseList);
//                                year1_Term2.adapter3.updateData(courseList);
//                                year1_Term2.adapter4.updateData(courseList);
//                                year1_Term2.adapter5.updateData(courseList);
//                                year1_Term2.adapter6.updateData(courseList);


                                year1_Term2.adapter.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term2.adapter2.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term2.adapter3.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term2.adapter4.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term2.adapter5.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term2.adapter6.notifyItemChanged(holder.getAdapterPosition());

//                                year1_Term2.adapter.notifyDataSetChanged();
//                                year1_Term2.adapter2.notifyDataSetChanged();
//                                year1_Term2.adapter3.notifyDataSetChanged();
//                                year1_Term2.adapter4.notifyDataSetChanged();
//                                year1_Term2.adapter5.notifyDataSetChanged();
//                                year1_Term2.adapter6.notifyDataSetChanged();

                                if (dbHelper.getIsCompleted("ECON1203") == 1) {
                                    dbHelper.eitherPrereq("MATH1041");
                                    dbHelper.eitherdisable("MATH1041");
                                }

                                if (dbHelper.getIsCompleted("MATH1041") == 1) {
                                    dbHelper.eitherPrereq("ECON1203");
                                    dbHelper.eitherdisable("ECON1203");
                                }

                                if (dbHelper.getIsCompleted("ACCT1511") == 1) {
                                    dbHelper.eitherPrereq("ECON1101");
                                    dbHelper.eitherdisable("ECON1101");
                                }

                                if (dbHelper.getIsCompleted("ECON1101") == 1) {
                                    dbHelper.eitherPrereq("ACCT1511");
                                    dbHelper.eitherdisable("ACCT1511");
                                }


                                Fragment fragment = (Fragment) ((FragmentActivity) mContext).getSupportFragmentManager().getFragments().get(1);
                                FragmentTransaction fragmentTransaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.detach(fragment);
                                fragmentTransaction.attach(fragment);
                                fragmentTransaction.commit();
//                                toast.makeText(mContext,"Tab No: " +tabNumber,Toast.LENGTH_SHORT).show();

                            }else if (tabNumber == 2) {


                                String termSelected = "T3";
                                dbHelper.updateTerm(course,termSelected);

//                                year1_Term3.adapter.updateData(courseList);
//                                year1_Term3.adapter2.updateData(courseList);
//                                year1_Term3.adapter3.updateData(courseList);
//                                year1_Term3.adapter4.updateData(courseList);
//                                year1_Term3.adapter5.updateData(courseList);
//                                year1_Term3.adapter6.updateData(courseList);

                                year1_Term3.adapter.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term3.adapter2.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term3.adapter3.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term3.adapter4.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term3.adapter5.notifyItemChanged(holder.getAdapterPosition());
                                year1_Term3.adapter6.notifyItemChanged(holder.getAdapterPosition());


                                if (dbHelper.getIsCompleted("ECON1203") == 1) {
                                    dbHelper.eitherPrereq("MATH1041");
                                    dbHelper.eitherdisable("MATH1041");
                                }

                                if (dbHelper.getIsCompleted("MATH1041") == 1) {
                                    dbHelper.eitherPrereq("ECON1203");
                                    dbHelper.eitherdisable("ECON1203");
                                }

                                if (dbHelper.getIsCompleted("ACCT1511") == 1) {
                                    dbHelper.eitherPrereq("ECON1101");
                                    dbHelper.eitherdisable("ECON1101");
                                }

                                if (dbHelper.getIsCompleted("ECON1101") == 1) {
                                    dbHelper.eitherPrereq("ACCT1511");
                                    dbHelper.eitherdisable("ACCT1511");
                                }


                                Fragment fragment = (Fragment) ((FragmentActivity) mContext).getSupportFragmentManager().getFragments().get(1);

                                FragmentTransaction fragmentTransaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                                fragmentTransaction.detach(fragment);
                                fragmentTransaction.attach(fragment);
                                fragmentTransaction.commit();
//                                toast.makeText(mContext,"Tab No: " +tabNumber,Toast.LENGTH_SHORT).show();
                            }

                            dialog.dismiss();
                        }
                    });

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });
                } else {
                    dialog = new Dialog(mContext);
                    dialog.setContentView(R.layout.activity_course_error);
                    ImageView closeButton = (ImageView) dialog.findViewById(R.id.closeButton);
                    TextView courseError = (TextView) dialog.findViewById(R.id.courseError);
                    courseError.setText(courseList.get(position).getCourseError());
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.show();

                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }

                    });

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView courseTitle;
        ImageView courseImage;
        CardView cardview;

        public MyViewHolder(View itemView) {

            super(itemView);
            courseTitle = (TextView) itemView.findViewById(R.id.courseTitle);
            courseImage = (ImageView) itemView.findViewById(R.id.courseImage);
            cardview = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }

}

