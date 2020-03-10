package edu.andrews.cptr252.aisensee.quoteoftheday;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Activity that displays a fact about the author of a quote.
 */
public class AuthorFactFragment extends Fragment {

    /** Text view for the author fact */
    private TextView mAuthorFactTextView;

    /** Creates a bundle with a reference to the information that the AuthorFact view will need.
     * @param authorFact a reference to the author fact
     * @return fragment
     * */
    public static AuthorFactFragment newInstance(int authorFact){


        Bundle args = new Bundle();

        args.putSerializable(QuoteFragment.EXTRA_AUTHOR_FACT, authorFact);

        AuthorFactFragment fragment = new AuthorFactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Inflates layout. Display the fact sent by QuoteActivity.
     * @param savedInstanceState Bundle object used to save activity state.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_author_fact, container, false);
        // get reference to TextView for the fact
        mAuthorFactTextView = (TextView) v.findViewById(R.id.authorTextFactView);

        // extract the resource id for the fact from the intent
        // if none is provided, display the "fact missing" message
        int authorFact = (int) getArguments().getSerializable(QuoteFragment.EXTRA_AUTHOR_FACT);
        // unpacks the intent

        // put the fact string in the fact TextView
        mAuthorFactTextView.setText(authorFact);
        return v;
    };
}
