package edu.andrews.cptr252.aisensee.quoteoftheday;

import androidx.fragment.app.Fragment;

/**
 * Activity that displays a fact about the author of a quote.
 */
public class AuthorFactActivity extends SingleFragmentActivity {

    /** Extends our SingleFragmentActivity class to display our AuthorFact, extracting
     * the author fact from the bundle that was passed to it. */
    @Override
    protected Fragment createFragment() {
        int authorQuote = (int) getIntent().getSerializableExtra(QuoteFragment.EXTRA_AUTHOR_FACT);
        return AuthorFactFragment.newInstance(authorQuote);
    }



}
