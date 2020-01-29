package edu.andrews.cptr252.aisensee.quoteoftheday;
/** model for a quote */
public class Quote {
    /** reference to quote text */
    private int mQuote;

    /** reference to quote's author */
    private int mAuthor;

    /** reference to a fact about the author */
    private int mAuthorFact;

    /**
     * Create a new quote
     * @param quote Resource id for quote text.
     * @param author Resource id for quote author.
     */
    public Quote(int quote, int author, int authorFact) {
        mQuote = quote;
        mAuthor = author;
        mAuthorFact = authorFact;
    }

    // getters and setters
    public int getQuote()               { return mQuote; }
    public void setQuote(int quote)     { mQuote = quote; }
    public int getAuthor()              { return mAuthor; }
    public void setAuthor(int author)   { mAuthor = author; }
    public int getAuthorFact()          { return mAuthorFact; }
    public void setAuthorFact(int mAuthorFact)   { this.mAuthorFact = mAuthorFact; }

}
