package unsw.Infs3605.Mydegree;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class MyDiffUtilCallback extends DiffUtil.Callback {

    private List<Course> oldList;
    private List<Course> newList;

    public MyDiffUtilCallback(List<Course> oldList, List<Course> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldPosition, int newPosition) {
        return oldPosition == newPosition;
    }

    @Override
    public boolean areContentsTheSame(int oldPosition, int newPosition) {
        return oldList.get(oldPosition) == newList.get(newPosition);
    }
}
