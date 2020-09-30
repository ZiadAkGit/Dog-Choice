package ziad.ak.wheelofdishes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    HashMap<String, String> dishes_re = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn1);
        final TextView txt = (TextView) findViewById(R.id.textView);
        final TextView txt2 = (TextView) findViewById(R.id.textView2);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    dishes_re.put(child.getKey(),child.getValue().toString());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int randomNumber = r.nextInt(dishes_re.size()-1);
                String[] hmapKeys = dishes_re.keySet().toString().replace("[", "").replace("]", "").trim().split(",");
                String choice = hmapKeys[randomNumber].trim();
                txt2.setText("Recipe: " + dishes_re.get(choice));
                txt2.setAllCaps(true);
                txt.setText(choice);
                txt.setAllCaps(true);
            }
        });
    }
}
