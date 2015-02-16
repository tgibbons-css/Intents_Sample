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
                    case 1:
                        Uri mylink = Uri.parse("http://www.css.edu");
                        intent = new Intent(Intent.ACTION_VIEW, mylink);
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_CALL,
                                Uri.parse("tel:(218)7236294"));
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:(218)7236294"));
                        break;
                    case 4:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:46.907005,-92.201879?z=19"));
                        break;
                    case 5:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q=query"));
                        break;
                    case 6:
                        intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        break;
                    case 7:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/"));
                        break;
                    case 8:
                        intent = new Intent(Intent.ACTION_EDIT,
                                Uri.parse("content://contacts/people/1"));
                        break;

                }
                if (intent != null) {
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
