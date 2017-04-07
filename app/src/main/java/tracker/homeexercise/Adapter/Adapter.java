package tracker.homeexercise.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tracker.homeexercise.Model.Event;
import tracker.homeexercise.Model.LeasureActivity;
import tracker.homeexercise.Model.Lecture;
import tracker.homeexercise.R;

/**
 * Created by Jan on 07.04.2017.
 */

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public interface OnBottomListener{
        void onBottom(int position);
    }

    private List<Event> data;
    private OnItemClickListener onItemClickListener;
    private OnBottomListener onBottomListener;

    public Adapter(List<Event> data, OnItemClickListener onItemClickListener,OnBottomListener onBottomListener)
    {
        this.data = data;
        this.onItemClickListener = onItemClickListener;
        this.onBottomListener = onBottomListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType== 42) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.lecture_item,parent,false);
            return new LectureViewHolder(onItemClickListener,view);
        }
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.leasure_item,parent,false);
            return new LeasureViewHolder(onItemClickListener,view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(position>=getItemCount()-1)
            onBottomListener.onBottom(position);
        if( data.get(position).getType() == 1337)
        {
            LeasureViewHolder viewHolder = (LeasureViewHolder) holder;
            LeasureActivity activity = (LeasureActivity)data.get(position);
            viewHolder.activity_name.setText(activity.getName());
            viewHolder.time.setText(activity.getTime().toString());
            viewHolder.setClickListener(position);
        }else if(data.get(position).getType() == 42)
        {
            LectureViewHolder viewHolder = (LectureViewHolder) holder;
            Lecture activity = (Lecture) data.get(position);
            viewHolder.course_name.setText(activity.getCourseName());
            viewHolder.time.setText(activity.getTime().toString());
            viewHolder.room.setText(activity.getRoom());
            viewHolder.setClickListener(position);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getType();
    }
}
