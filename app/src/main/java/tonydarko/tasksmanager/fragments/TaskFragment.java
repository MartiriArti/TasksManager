package tonydarko.tasksmanager.fragments;

import android.app.Fragment;
import android.support.v7.widget.RecyclerView;

import tonydarko.tasksmanager.adapters.CurrentTasksAdapter;
import tonydarko.tasksmanager.model.ModelTask;

public abstract class TaskFragment extends Fragment{
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private CurrentTasksAdapter adapter;



    public void addTask(ModelTask newTask){
        int position = - 1;

        for(int i = 0; i < adapter.getItemCount(); i++){
            if(adapter.getItem(i).isTask()){
                ModelTask task = (ModelTask) adapter.getItem(i);
                if(newTask.getDate() < task.getDate()){
                    position = i;
                    break;
                }
            }

        }

        if (position != -1){
            adapter.addItem(position, newTask);
        } else {
            adapter.addItem(newTask);
        }

    }


}
