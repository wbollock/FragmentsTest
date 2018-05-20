package wbollock.com.fragmentstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // this gets called by the Top Fragment when the user clicks the button
    @Override
    public void createMeme(String top, String bottom) { // alt-insert implement method.
        BottomPictureFragment bottomFragment = (BottomPictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2); // getting a reference to bottom fragment
        bottomFragment.setMemeText(top, bottom);
    }
}
