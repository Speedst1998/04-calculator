package campbell.ca.hw;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.EditText;

/**
 * Created by 1534979 on 9/22/2017.
 */

public class MapActivity extends AppCompatActivity {

    String input;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        et = (EditText)findViewById(R.id.num2);
        et.setText(getIntent().getStringExtra("country"));
        // get a handle to text fields

    }

    public void onClick(View v){

        input = et.getText().toString();
        Uri  uri = Uri.parse("geo:0,0?q=" + Uri.encode(input));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            et.setText(R.string.error_no_geo);
        }
    }

}
