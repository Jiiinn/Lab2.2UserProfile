package my.edu.taruc.lab22userprofile;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUESST_PROFILE_UPDATE = 1;
    public static final String USER_EMAIL = "my.edu.taruc.lab22userprofile.email";
    public static final String USER_ID = "my.edu.taruc.lab22userprofile.id";
    private TextView textViewID, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewID = (TextView)findViewById(R.id.textViewID);
        textViewEmail = (TextView)findViewById(R.id.textViewEmail);

    }

    public void editProfile(View view){
        //An explicit intent
        String a=textViewID.getText().toString();
        String b=textViewEmail.getText().toString();
        Intent intent = new Intent(this, ProfileActivity.class);

        startActivityForResult(intent, REQUESST_PROFILE_UPDATE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //requestCode = the unique code that the activity sent with an intent
        //resultCode = store the OK or CANCEL
        //data = the data returned from an intent

        super.onActivityResult(requestCode, resultCode, data);

        //if(requestCode == REQUESST_PROFILE_UPDATE && resultCode == RESULT_OK)

        if(requestCode == REQUESST_PROFILE_UPDATE){
            String id, email;
            id = data.getStringExtra(USER_ID);
            email = data.getStringExtra(USER_EMAIL);

            //Display data on UI
            textViewID.setText(getString(R.string.user_id) + " " + id);
            textViewEmail.setText(getString(R.string.email) + " " + email);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main Activity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main Activity", "OnResume");
    }


}
