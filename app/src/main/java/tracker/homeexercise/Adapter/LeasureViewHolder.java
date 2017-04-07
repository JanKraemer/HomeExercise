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

public class LeasureViewHolder extends RecyclerView.ViewHolder {

     CircleImageView imageView;
     CardView cardView;
     TextView activity_name;
     TextView time;
     Adapter.OnItemClickListener listener;

    public LeasureViewHolder(Adapter.OnItemClickListener listener,View itemView) {
        super(itemView);
        this.listener = listener;
        imageView = (CircleImageView) itemView.findViewById(R.id.leasure_image);
        cardView = (CardView) itemView.findViewById(R.id.leasure_cardView);
        activity_name = (TextView) itemView.findViewById(R.id.activity_name);
        time = (TextView) itemView.findViewById(R.id.leasure_time);
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

