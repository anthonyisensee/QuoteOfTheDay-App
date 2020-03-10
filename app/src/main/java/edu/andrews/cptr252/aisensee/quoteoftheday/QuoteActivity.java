package edu.andrews.cptr252.aisensee.quoteoftheday;

import androidx.fragment.app.Fragment;

/**
 * Main activity for the application.
 * Displays a series of quotes.
 */

public class QuoteActivity extends SingleFragmentActivity {

    /** Creates our new QuoteFragment by extending the properties of SingleFragmentActivity */
    @Override
    protected Fragment createFragment() {
        return new QuoteFragment();
    }

    /** Key for fact about author stored in Intent sent to AuthorFactActivity. */
    public static final String EXTRA_AUTHOR_FACT = "edu.andrews.cptr252.aisensee.quoteoftheday.author_fact";

    /** Key used to access the quote index by adding it to a Bundle. */
    private static final String KEY_QUOTE_INDEX = "quoteIndex"; // unlike the EXTRA_AUTHOR_FACT key above, this is private, as only used in this class.

}
