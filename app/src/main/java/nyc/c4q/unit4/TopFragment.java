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
        Bundle bundle = getArguments();
        title = (TextView) view.findViewById(R.id.top_title);
        author = (TextView) view.findViewById(R.id.top_author);
        year = (TextView) view.findViewById(R.id.top_year);

        setTitle =  bundle.getString("title","");
        setAuthor = bundle.getString("author","");
        setYear = bundle.getString("year","");

        title.setText(setTitle);
        author.setText(setAuthor);
        year.setText(setYear);

        return view;
    }

}














