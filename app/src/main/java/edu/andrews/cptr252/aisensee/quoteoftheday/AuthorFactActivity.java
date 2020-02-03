package edu.andrews.cptr252.aisensee.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import android.os.Bundle;

/**
 * Activity that displays a fact about the author of a quote.
 */
public class AuthorFactActivity extends AppCompatActivity {
    private TextView mAuthorFactTextView;

    /**
     * Inflates layout. Display the fact sent by QuoteActivity.
     * @param savedInstanceState Bundle object used to save activity state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_fact);

        // get reference to TextView for the fact
        mAuthorFactTextView = (TextView) findViewById(R.id.authorTextFactView);

        // extract the resource id for the fact from the intent
        // if none is provided, display the "fact missing" message
        int authorFact = getIntent().getIntExtra(QuoteActivity.EXTRA_AUTHOR_FACT, R.string.fact_missing);

        // put the fact string in the fact TextView
        mAuthorFactTextView.setText(authorFact);
    }
}
