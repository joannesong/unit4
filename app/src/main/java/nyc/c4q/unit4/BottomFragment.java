package nyc.c4q.unit4;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.unit4.controller.BookAdapter;
import nyc.c4q.unit4.model.Books;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    private List<Books> booksList;

    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_bottom, container, false);
        context = view.getContext();
        recyclerView = view.findViewById(R.id.rv);

        try {
            JSONObject jsonObject = new JSONObject("{\n" +
                    "  \"books\": [\n" +
                    "    {\n" +
                    "      \"title\": \"Northanger Abbey\",\n" +
                    "      \"author\": \"Austen, Jane\",\n" +
                    "      \"year\": 1814\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"War and Peace\",\n" +
                    "      \"author\": \"Tolstoy, Leo\",\n" +
                    "      \"year\": 1865\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"Anna Karenina\",\n" +
                    "      \"author\": \"Tolstoy, Leo\",\n" +
                    "      \"year\": 1875\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"Mrs. Dalloway\",\n" +
                    "      \"author\": \"Woolf, Virginia\",\n" +
                    "      \"year\": 1925\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"The Hours\",\n" +
                    "      \"author\": \"Cunnningham, Michael\",\n" +
                    "      \"year\": 1999\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"Huckleberry Finn\",\n" +
                    "      \"author\": \"Twain, Mark\",\n" +
                    "      \"year\": 1865\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"Bleak House\",\n" +
                    "      \"author\": \"Dickens, Charles\",\n" +
                    "      \"year\": 1870\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"title\": \"Tom Sawyer\",\n" +
                    "      \"author\": \"Twain, Mark\",\n" +
                    "      \"year\": 1862\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}\n");
            Log.e("myJsonobject",jsonObject.toString());
            booksList = parseJSONArray(jsonObject);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        BookAdapter bookAdapter = new BookAdapter(booksList);
        recyclerView.setAdapter(bookAdapter);
        return view;
    }

    private List<Books> parseJSONArray(JSONObject jsonObject) {
        List<Books> parsedBookList = new ArrayList<>();

        try {
            JSONArray jsonArray = jsonObject.getJSONArray("books");
            Log.e("JSONARRAY", jsonArray.toString());
            for (int i = 0; i < jsonArray.length() ; i++) {
                Books books = new Books();
                JSONObject bookObject = (JSONObject) jsonArray.get(i);
                String title = bookObject.getString("title");
                String author = bookObject.getString("author");
                int year = bookObject.getInt("year");

                books.setTitle(title);
                books.setAuthor(author);
                books.setYear(year);

                parsedBookList.add(books);
                Log.e("parsedBookList", parsedBookList.toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("parsedBookList2", parsedBookList.toString());

        return parsedBookList;
    }


}
