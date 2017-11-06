package my.edu.taruc.lab22userprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {
    private EditText editTextID, editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextID = (EditText)findViewById(R.id.editTextID);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);

    }

    public void setProfile(View view){
        Intent intent = new Intent();
        String id, email;
        id = editTextID.getText().toString();
        email =  editTextEmail.getText().toString();
        intent.putExtra(MainActivity.USER_ID, id);
        intent.putExtra(MainActivity.USER_EMAIL, email);

        setResult(MainActivity.REQUESST_PROFILE_UPDATE, intent);

        finish();
    }


}
