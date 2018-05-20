package wbollock.com.fragmentstest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity; // to talk to main activity
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;


public class TopSectionFragment extends Fragment { // extends Fragment means the class inherits from Fragment

    private static EditText topTextInput; // variables for text input
    private static EditText bottomTextInput;

    TopSectionListener activityCommander; // creating an interface object

    public interface TopSectionListener{ // now, say that this interface, implemented by main activity,
        public void createMeme(String top, String bottom); // saying, i (main activity) promise ill use this method to pass in top/bottom text
    }

    @Override
    public void onAttach(Activity activity) { // passes a reference of the main activity to the fragment
        super.onAttach(activity);
        try {
            activityCommander = (TopSectionListener) activity;
        } catch(ClassCastException e) {
            throw new ClassCastException(activity.toString());
        } // end of catch
    } // end of onAttach

    @Nullable
    @Override // says, we know this is a fragment. but what does this fragment look like?
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.top_section_fragment, container, false);

         topTextInput = (EditText) view.findViewById(R.id.topTextInput); // typecast into EditText...edit what text? the text that is found at ID topTextInput
         bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
         final Button button = (Button) view.findViewById(R.id.button);
         // still need a listener. button will be waiting for something to happen
        button.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        buttonClicked(v); // need method for button being clicked
                    }

                }

        ); // emd of listener
         return view; // returns view to OnCreate
    } // end of onCreate
        // classes this when button is clicked
    public void buttonClicked(View view){ // method for button being clicked
        activityCommander.createMeme(topTextInput.getText().toString(), bottomTextInput.getText().toString());
    }


}
