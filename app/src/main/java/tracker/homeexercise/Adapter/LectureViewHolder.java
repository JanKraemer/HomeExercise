package tracker.homeexercise.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import de.hdodenhof.circleimageview.CircleImageView;
import tracker.homeexercise.R;


/**
 * Created by Jan on 07.04.2017.
 */

public class LectureViewHolder extends RecyclerView.ViewHolder {

     CircleImageView imageView;
     CardView cardView;
     TextView course_name;
     TextView room;
     TextView time;
     Adapter.OnItemClickListener listener;

    public LectureViewHolder(Adapter.OnItemClickListener listener,View itemView) {
        super(itemView);
        this.listener = listener;
        imageView = (CircleImageView) itemView.findViewById(R.id.lecture_image);
        cardView = (CardView) itemView.findViewById(R.id.lecture_cardView);
        course_name = (TextView) itemView.findViewById(R.id.course_name);
        time = (TextView) itemView.findViewById(R.id.lecture_time);
        room = (TextView) itemView.findViewById(R.id.lecture_room);
    }

    void setClickListener(final int position)
    {
        final View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            public void onClick(final View v){
                listener.onClick(position);
            }
        };
        cardView.setOnClickListener(onClickListener);
    }
}
