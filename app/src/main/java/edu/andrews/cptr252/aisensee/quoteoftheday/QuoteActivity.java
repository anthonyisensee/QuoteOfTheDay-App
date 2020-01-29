package edu.andrews.cptr252.aisensee.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

public class QuoteActivity extends AppCompatActivity {
    public static final String EXTRA_AUTHOR_FACT =
            "edu.andrews.cptr252.aisensee.quoteoftheday.author_fact";

    private TextView mQuoteTextView;
    private TextView mAuthorTextView;
    private Button mNextButton;

    /** Quotes used in app */
    private Quote[] mQuoteList = new Quote[]{
            new Quote(R.string.quote_text_0, R.string.quote_author_0, R.string.author_fact_0),
            new Quote(R.string.quote_text_1, R.string.quote_author_1, R.string.author_fact_1),
            new Quote(R.string.quote_text_2, R.string.quote_author_2, R.string.author_fact_2),
    };

    /** Index of current quote in list. */
    private int mCurrentIndex = 0;

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

        mQuoteTextView.setText(quote);
        mAuthorTextView.setText(author);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote);

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
