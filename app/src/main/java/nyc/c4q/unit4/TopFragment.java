package nyc.c4q.unit4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    private TextView title;
    private TextView author;
    private TextView year;
    private Bundle bundle;
    private String setTitle;
    private String setAuthor;
    private String setYear;

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_top, container, false);
        bundle = getArguments();
        title = view.findViewById(R.id.title_text);
        author = view.findViewById(R.id.author_text);
        year = view.findViewById(R.id.year_text);


//        Log.e("bundle", bundle.toString());
        setTitle = bundle.getString("title");
        setAuthor = bundle.getString("author");
        setYear = bundle.getString("year");

        title.setText(setTitle);
        author.setText(setAuthor);
        year.setText(setYear);

        return view;
    }

}














