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
import nyc.c4q.unit4.TopFragment;
import nyc.c4q.unit4.model.Books;

/**
 * Created by joannesong on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private TextView author;
    private TextView year;
    private Context context;
    private Bundle bundle;

    public BookViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_text);
        author = itemView.findViewById(R.id.author_text);
        year = itemView.findViewById(R.id.year_text);
        context = itemView.getContext();
        bundle = new Bundle();

    }

    public void onBind(Books books){
        title.setText(books.getTitle());
        author.setText(books.getAuthor());
        year.setText(books.getYear() + "");

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("title", title.getText().toString());
                bundle.putString("author", author.getText().toString());
                bundle.putString("year", year.getText().toString());

//                Log.e("bundleVH", bundle.toString());

                TopFragment topFragment = new TopFragment();
                topFragment.setArguments(bundle);
                FragmentManager fragmentManager= ((FragmentActivity) context).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.top_fragment_container,topFragment).commit();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.addToBackStack(null).replace(R.id.top_fragment_container, topFragment);
//                fragmentTransaction.commit();

            }
        });

    }
}
