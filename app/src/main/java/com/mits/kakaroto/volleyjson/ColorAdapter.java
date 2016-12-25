package com.mits.kakaroto.volleyjson;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kakaroto on 12/21/16.
 */

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.MyViewHolder> {

    private List<Color> dataset;

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvNumber, tvColorName, tvColorHex;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvNumber = (TextView) itemView.findViewById(R.id.tv_colorNumber);
            tvColorName = (TextView) itemView.findViewById(R.id.tv_colorName);
            tvColorHex = (TextView) itemView.findViewById(R.id.tv_colorHex);
        }
    }

    public ColorAdapter(List<Color> dataset){
        this.dataset = dataset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_color, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Color colors = dataset.get(position);

        holder.tvNumber.setText(colors.getNumber());
        holder.tvColorName.setText(colors.getColorName());
        holder.tvColorHex.setText(colors.getColorHex());

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
