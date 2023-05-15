package sg.edu.np.mad.madpract3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

import sg.edu.np.mad.madpract2.R;

public class ListActivity extends AppCompatActivity {

    final String title = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(title, "Started!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title, "Resume...");
        ImageView clickimage = findViewById(R.id.imageView);
        clickimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(title, "User clicked Image");
                queryImgClick();
            }
        });
    }

    private void queryImgClick(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "User close");
                finish();
            }
        });
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "User views");
                //go to MainActivity
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                int randomUsername1 = randomUsername();
                String randomUsername1_1 = "MAD "+ randomUsername1;
                myIntent.putExtra("Username", randomUsername1_1);
                Log.v(title, "Username: " + randomUsername1_1);
                startActivity(myIntent);
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();

    }

    private int randomUsername(){
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(999999999);
        return myRandomNumber;

    }
}