package nyc.c4q.unit4.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.unit4.BottomFragment;
import nyc.c4q.unit4.DisplayFragment;
import nyc.c4q.unit4.R;
import nyc.c4q.unit4.model.Books;

/**
 * Created by joannesong on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private TextView author;
    private TextView year;
    private Context context;

    public BookViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_text);
        author = itemView.findViewById(R.id.author_text);
        year = itemView.findViewById(R.id.year_text);
        context = itemView.getContext();

    }

    public void onBind(Books books){
        title.setText(books.getTitle());
        author.setText(books.getAuthor());
        year.setText(books.getYear() + "");

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", title.getText() + "");
                bundle.putString("author", author.getText() + "");
                bundle.putString("year", year.getText() + "");

                Log.e("bundleVH", bundle.toString());

                DisplayFragment displayFragment = new DisplayFragment();
                displayFragment.setArguments(bundle);
                FragmentManager fragmentManager= ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null).replace(R.id.fragment_container, displayFragment);
                fragmentTransaction.commit();

            }
        });

    }
}
