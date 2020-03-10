package edu.andrews.cptr252.aisensee.quoteoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/** A class that contains all the information for our quote fragment, and sends the information
 * needed to QuoteActivity.
 */
public class QuoteFragment extends Fragment {

    /**
     * Key for fact about author stored in Intent sent to AuthorFactActivity.
     */
    public static final String EXTRA_AUTHOR_FACT = "edu.andrews.cptr252.aisensee.quoteoftheday.author_fact";

    /**
     * Key used to access the quote index by adding it to a Bundle.
     */
    private static final String KEY_QUOTE_INDEX = "quoteIndex"; // unlike the EXTRA_AUTHOR_FACT key above, this is private, as only used in this class.

    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;

    /**
     * ImageView used to display inspirational image
     */
    private ImageView mImageView;

    /**
     * Quotes used in app
     */
    private Quote[] mQuoteList = new Quote[]{
            new Quote(R.string.quote_text_0, R.string.quote_author_0, R.string.author_fact_0, R.drawable.coastline_picture),
            new Quote(R.string.quote_text_1, R.string.quote_author_1, R.string.author_fact_1, R.drawable.lake_picture),
            new Quote(R.string.quote_text_2, R.string.quote_author_2, R.string.author_fact_2, R.drawable.mountain_picture),
            new Quote(R.string.quote_text_3, R.string.quote_author_3, R.string.author_fact_3, R.drawable.sky_picture),
            new Quote(R.string.quote_text_4, R.string.quote_author_4, R.string.author_fact_4, R.drawable.sunrise_picture),
    };

    /**
     * Index of current quote in list.
     */
    private int mCurrentIndex = 0;

    /**
     * Remember the current quote when the activity is destroyed.
     * Allows us to rotate the device and preserve the current quote.
     *
     * @param savedInstanceState Bundle used for saving identity of current quote.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Store the index of the current quote in the Bundle.
        // We will be able to use the KEY_QUOTE_INDEX key to access the mCurrentIndex in onCreate.
        // Note that this is also a key/value pair.
        savedInstanceState.putInt(KEY_QUOTE_INDEX, mCurrentIndex);
    }

    /**
     * Launch activity to display author fact
     */
    private void displayAuthorFact() {
        // Create intent with name of class for second activity.
        // This intent will be sent to the Activity Manger in the OS
        // which will launch the activity
        Intent i = new Intent(getContext(), AuthorFactActivity.class);  // getContext correct? Talk to Noah.
        // add extra containing resource id for fact
        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());
        // send the intent to the Activity Manger.
        startActivity(i);   // actually starts the activity

    }

    /**
     * Display the quote at the current index
     */
    private void updateQuote() {
        int quote = mQuoteList[mCurrentIndex].getQuote();
        int author = mQuoteList[mCurrentIndex].getAuthor();
        int image = mQuoteList[mCurrentIndex].getImage();

        mImageView.setImageResource(image);
        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
    }

    /**
     * Setup and inflate layout.
     *
     * @param savedInstanceState Previously saved Bundle.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /** Everything gets set up and inflated, here. */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_quote, container, false);
        // Re-display the same quote we were on when the activity was destroyed.
        // note that this happens first in the onCreate so that checking for this position is prioritized.
        if (savedInstanceState != null) {   // if the key/value pair hasn't been created, the Bundle will not have been created.
            mCurrentIndex = savedInstanceState.getInt(KEY_QUOTE_INDEX); // extracts the Bundled mCurrentIndex and sets it to the proper index.
        }

        // display image
        mImageView = v.findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.coastline_picture);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAuthorFact();
            }

        });

        // get references to our text views
        mQuoteTextView = v.findViewById(R.id.quoteTextView);
        mQuoteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAuthorFact();
            }
        });

        mAuthorTextView = v.findViewById(R.id.authorTextView);
        mAuthorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayAuthorFact();
            }
        });

        // display the current quote and it's author
        updateQuote();

        // set up listener to handle next button presses
        mNextButton = v.findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // move to next quote in the list
                // if index reaches end of array,
                // reset index to zero (first quote)
                mCurrentIndex++;
                if (mCurrentIndex == mQuoteList.length) {
                    mCurrentIndex = 0;
                }
                updateQuote();
            }
        });
        return v;
    }
}
