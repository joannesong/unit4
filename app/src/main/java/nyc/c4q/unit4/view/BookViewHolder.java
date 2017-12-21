package nyc.c4q.unit4.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.unit4.R;
import nyc.c4q.unit4.model.Books;

/**
 * Created by joannesong on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private TextView author;
    private TextView year;

    public BookViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_text);
        author = itemView.findViewById(R.id.author_text);
        year = itemView.findViewById(R.id.year_text);

    }

    public void onBind(Books books){
        title.setText(books.getTitle());
        author.setText(books.getAuthor());
        year.setText(books.getYear() + "");

    }
}
