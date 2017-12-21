package nyc.c4q.unit4.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit4.R;
import nyc.c4q.unit4.model.Books;
import nyc.c4q.unit4.view.BookViewHolder;

/**
 * Created by joannesong on 12/20/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{

    List<Books> booksList = new ArrayList<>();

    public BookAdapter(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_itemview,parent,false);

        return new BookViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        holder.onBind(booksList.get(position));
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }
}












