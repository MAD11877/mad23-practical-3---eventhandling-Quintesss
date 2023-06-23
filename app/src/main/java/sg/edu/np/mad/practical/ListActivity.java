package sg.edu.np.mad.practical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {
    String title = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView userImage = findViewById(R.id.imageView2);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            profileViewAlert();
            }
        });
    }

    private void profileViewAlert(){
        AlertDialog.Builder userAlert = new AlertDialog.Builder(this);
        userAlert.setTitle("Profile");
        userAlert.setMessage("MADness");
        userAlert.setCancelable(false);
        userAlert.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "User Views!");
                Intent listToMainIntent = new Intent(ListActivity.this, MainActivity.class);
                int randomUsername1 = randomUsername();
                String randomUsername1_1 = "MAD "+ randomUsername1;
                listToMainIntent.putExtra("Username", randomUsername1_1);
                Log.v(title, "Username: " + randomUsername1_1);
                startActivity(listToMainIntent);
            }
        });

        userAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "User Cancelled!");
                finish();
            }
        });

        userAlert.show();
    }

    private int randomUsername(){
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(999999999);
        return myRandomNumber;

    }

}