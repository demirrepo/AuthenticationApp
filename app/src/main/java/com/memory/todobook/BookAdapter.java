package com.memory.todobook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    List<Book> books;
    Context context;
    Book current_book;
    Activity activity;

    public BookAdapter(Activity activity, Context context, List<Book> books){
        this.books = books;
        this.context = context;
        this.activity = activity;
    }


    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.list_tem, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Book book = books.get(position);

        TextView id = holder.id, author = holder.author, title = holder.title, pages = holder.pages;

        id.setText(String.valueOf(book.getId()));
        title.setText(book.getTitle());
        author.setText(book.getAuthor());
        pages.setText(String.valueOf(book.getPages()));


        holder.root_element.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("book", books.get(position));
                activity.startActivityForResult(intent, 1);
            }
        });


    }


    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id, title, author, pages;
        public LinearLayout root_element;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.book_id);
            title = itemView.findViewById(R.id.book_title);
            author = itemView.findViewById(R.id.book_author);
            pages = itemView.findViewById(R.id.book_pages);
            root_element = itemView.findViewById(R.id.root_element);

        }
    }
}
