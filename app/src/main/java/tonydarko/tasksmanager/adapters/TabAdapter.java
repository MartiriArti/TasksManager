package tonydarko.tasksmanager.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import tonydarko.tasksmanager.fragments.CurrentTaskFragment;
import tonydarko.tasksmanager.fragments.DoneTaskFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public final static int CURRENT_TASK_FRAGMENT_POSITION = 0;
    public final static int DONE_TASK_FRAGMENT_POSITION = 1;

    private CurrentTaskFragment currentTaskFragment;
    private DoneTaskFragment doneTaskFragment;



    public TabAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        currentTaskFragment = new CurrentTaskFragment();
        doneTaskFragment = new DoneTaskFragment();
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return currentTaskFragment;
            case 1:
                return doneTaskFragment;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
