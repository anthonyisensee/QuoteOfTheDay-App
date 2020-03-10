package edu.andrews.cptr252.aisensee.quoteoftheday;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * Generic activity for hosting a single fragment.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {    // derived classes must implement this method

    /** Returns instance of fragment that will be hosted by the activity */
    protected abstract Fragment createFragment();

    /** Defines what the onCreate for the given fragment will look like, in the most basic sense */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        // any fragment can now be created here. The derived class creates the desired fragment in their createFragment() method.
        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
