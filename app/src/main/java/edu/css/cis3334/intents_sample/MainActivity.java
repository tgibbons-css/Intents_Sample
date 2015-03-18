package edu.css.cis3334.intents_sample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.apache.http.protocol.HTTP;


public class MainActivity extends ActionBarActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.intents, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //int position = spinner.getSelectedItemPosition();
                Intent intent = null;
                switch (position) {
                    // call an intent to do the required action
                    case 1:
                        // Visit the CSS website
                        Uri mylink = Uri.parse("http://www.css.edu");
                        intent = new Intent(Intent.ACTION_VIEW, mylink);
                        break;
                    case 2:
                        // call a telephone number, but don't dial it yet.
                        intent = new Intent(Intent.ACTION_CALL,
                                Uri.parse("tel:(218)7236294"));
                        break;
                    case 3:
                        // place a call, dial a number
                        intent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(218)7236294"));
                        break;
                    case 4:
                        // displace a map location on the map app
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:46.907005,-92.201879?z=19"));
                        break;
                    case 5:
                        // bring up the map app and lets you search for something
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=query"));
                        break;
                    case 6:
                        // Use the camera app to take a photo
                        intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 7:
                        // bring up the contacts so you can search for someone
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/"));
                        break;
                    case 8:
                        // bring up the contacts so yo can edit someone
                        intent = new Intent(Intent.ACTION_EDIT,
                                Uri.parse("content://contacts/people/1"));
                        break;
                    case 9:
                        // send a text or SMS message
                        //intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
                        //Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setType(HTTP.PLAIN_TEXT_TYPE);
                        intent.putExtra("sms_body", "Hi");

                        //intent.putExtra(Intent.EXTRA_STREAM, attachment);
                        break;

                }
                if ((intent != null) && (intent.resolveActivity(getPackageManager()) != null)) {
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // do nothing here
            }

        });



    }


}
