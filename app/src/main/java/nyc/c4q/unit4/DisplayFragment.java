package nyc.c4q.unit4;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    private Bundle bundle;
    private Context context;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_display, container, false);
        context = view.getContext();
        bundle = getArguments();
        TopFragment topFragment = new TopFragment();
        topFragment.setArguments(bundle);
        FragmentManager topFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction topFragmentTransaction = topFragmentManager.beginTransaction();
        topFragmentTransaction.addToBackStack(null).replace(R.id.top_fragment_container, topFragment);
        topFragmentTransaction.commit();

        BottomFragment bottomFragment = new BottomFragment();
        FragmentManager bottomFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        FragmentTransaction bottomFragmentTransaction = bottomFragmentManager.beginTransaction();
        bottomFragmentTransaction.addToBackStack(null).replace(R.id.bottom_fragment_container, bottomFragment);
        bottomFragmentTransaction.commit();

        return view;
    }

}
