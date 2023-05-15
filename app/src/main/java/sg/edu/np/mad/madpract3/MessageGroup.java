package sg.edu.np.mad.madpract3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import sg.edu.np.mad.madpract2.R;

public class MessageGroup extends AppCompatActivity {
    final String title = "MessageGroup";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(title,"Message Resumed");

        Button button_grp1 = findViewById(R.id.button3);
        Button button_grp2 = findViewById(R.id.button5);

        FragmentManager fragmentManager = getSupportFragmentManager();

        button_grp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, Group1_Fragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}