package tonydarko.tasksmanager.adapters;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import tonydarko.tasksmanager.R;
import tonydarko.tasksmanager.Utils;
import tonydarko.tasksmanager.fragments.CurrentTaskFragment;
import tonydarko.tasksmanager.fragments.TaskFragment;
import tonydarko.tasksmanager.model.Item;
import tonydarko.tasksmanager.model.ModelTask;

public class CurrentTasksAdapter extends TaskAdapter {

    private static final int TYPE_TASK = 0;
    private static final int TYPE_SEPARATOR = 1;

    public CurrentTasksAdapter(CurrentTaskFragment taskFragment) {
        super(taskFragment);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_TASK:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_task, parent, false);
                TextView title = (TextView) view.findViewById(R.id.tvTaskTitle);
                TextView date = (TextView) view.findViewById(R.id.tvTaskDate);
                CircleImageView priority = (CircleImageView) view.findViewById(R.id.cvTaskPrioriti);
                return new TaskViewHolder(view,title,date, priority);

        //    case TYPE_SEPARATOR:

            default:         return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);

        if (item.isTask()){
            holder.itemView.setEnabled(true);
            ModelTask modelTask = (ModelTask) item;
            TaskViewHolder taskViewHolder = (TaskViewHolder) holder;

            View itemView = taskViewHolder.itemView;
            Resources resources = itemView.getResources();

            taskViewHolder.title.setText(modelTask.getTitle());
            if(modelTask.getDate() != 0){
                taskViewHolder.date.setText(Utils.getFullDate(modelTask.getDate()));
            } else {
                taskViewHolder.date.setText(null);
            }

            itemView.setVisibility(View.VISIBLE);

            itemView.setBackgroundColor(resources.getColor(R.color.gray_50));

            taskViewHolder.title.setTextColor(resources.getColor(R.color.primary_text_default_material_light));
            taskViewHolder.date.setTextColor(resources.getColor(R.color.secondary_text_default_material_light));
            taskViewHolder.priority.setColorFilter(resources.getColor(modelTask.getPriorityColor()));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position).isTask()) {
            return TYPE_TASK;
        } else {
            return TYPE_SEPARATOR;
        }

    }
}
