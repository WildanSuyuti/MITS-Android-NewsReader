package com.mits.kakaroto.volleyjson;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kakaroto on 12/21/16.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {
    private Context context;
    private List<Articles> dataset;

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView author, titile, description, url, urlImage, published;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            author = (TextView) itemView.findViewById(R.id.tv_author);
            titile = (TextView) itemView.findViewById(R.id.tv_title);
            description = (TextView) itemView.findViewById(R.id.tv_description);
            url = (TextView) itemView.findViewById(R.id.tv_url);
            published = (TextView) itemView.findViewById(R.id.tv_published);

            image = (ImageView) itemView.findViewById(R.id.img_article);
        }
    }

    public ArticleAdapter(Context context, List<Articles> dataset){
        this.dataset = dataset;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_articles, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Articles articles = dataset.get(position);

        holder.author.setText(articles.getAuthor());
        holder.titile.setText(articles.getTitle());
        holder.description.setText(articles.getDescription());
        holder.url.setText(articles.getUrl());
        holder.published.setText(articles.getPublished());

        //Picasso.with(this).load(articles.getUrlImage()).into(holder.image);
        Glide.with(context).load(articles.getUrlImage()).into(holder.image);

        //holder.duration.setText(movie.getDuration());
//        holder.image.setImageResource(movie.getImageAddrees());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public Articles getItem(int position) {
        return dataset.get(position);
    }

    public void insert(Articles newMovie) {
        dataset.add(0, newMovie);
        notifyItemInserted(0);
    }

     public void remove(int position){
        dataset.remove(position);
        notifyItemRemoved(position);
    }

}
