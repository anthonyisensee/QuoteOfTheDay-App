package edu.andrews.cptr252.aisensee.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

/**
 * Main activity for the application.
 * Displays a series of quotes.
 */

public class QuoteActivity extends AppCompatActivity {
    /** Key for fact about author stored in Intent sent to AuthorFactActivity. */
    public static final String EXTRA_AUTHOR_FACT =
            "edu.andrews.cptr252.aisensee.quoteoftheday.author_fact";
    private static final String KEY_QUOTE_INDEX = "quoteIndex";

    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;

    /** ImageView used to display inspirational image */
    private ImageView mImageView;

    /** Quotes used in app */
    private Quote[] mQuoteList = new Quote[]{
            new Quote(R.string.quote_text_0, R.string.quote_author_0, R.string.author_fact_0, R.drawable.coastline_picture),
            new Quote(R.string.quote_text_1, R.string.quote_author_1, R.string.author_fact_1, R.drawable.lake_picture),
            new Quote(R.string.quote_text_2, R.string.quote_author_2, R.string.author_fact_2, R.drawable.mountain_picture),
            new Quote(R.string.quote_text_3, R.string.quote_author_3, R.string.author_fact_3, R.drawable.sky_picture),
            new Quote(R.string.quote_text_4, R.string.quote_author_4, R.string.author_fact_4, R.drawable.sunrise_picture),
    };

    /** Index of current quote in list. */
    private int mCurrentIndex = 0;

    /**
     * Remember the current quote when the activity is destroyed
     * @param savedInstanceState Bundle used for saving identity of current quote.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Store the index of the current quote in the Bundle.
        // Use our key to access the value later.
        savedInstanceState.putInt(KEY_QUOTE_INDEX, mCurrentIndex);
    }

    /** Launch activity to display author fact */
    private void displayAuthorFact() {
        // Create intent with name of class for second activity.
        // This intent will be sent to the Activity Manger in the OS
        // which will launch the activity
        Intent i = new Intent(QuoteActivity.this, AuthorFactActivity.class);
        // add extra containing resource id for fact
        i.putExtra(EXTRA_AUTHOR_FACT, mQuoteList[mCurrentIndex].getAuthorFact());
        // send the intent to the Activity Manger.
        startActivity(i);

    }

    /** Display the quote at the current index */
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
     * @param savedInstanceState Previously saved Bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

        // Re-display the same quote we were on when the activity was destroyed.
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_QUOTE_INDEX);
        }

        // display image
        mImageView = findViewById(R.id.imageView);
        mImageView.setImageResource(R.drawable.coastline_picture);
        // get references to our text views
        mQuoteTextView = findViewById(R.id.quoteTextView);
        mQuoteTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayAuthorFact();
            }
        });

        mAuthorTextView = findViewById(R.id.authorTextView);
        mAuthorTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayAuthorFact();
            }
        });

        // display the current quote and it's author
        updateQuote();

        // set up listener to handle next button presses
        mNextButton = findViewById(R.id.nextButton);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // move to next quote in the list
                // if index reaches end of array,
                // reset index to zero (first quote)
                mCurrentIndex++;
                if (mCurrentIndex == mQuoteList.length){
                    mCurrentIndex = 0;
                }
                updateQuote();
            }
        });

    }

}
