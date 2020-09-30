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
    HashMap<String, String> dessert_re = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button dishesbtn = findViewById(R.id.btn1);
        Button dessertbtn = findViewById(R.id.btn2);
        final TextView txt = findViewById(R.id.textView);
        final TextView txt2 = findViewById(R.id.textView2);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot child : snapshot.getChildren()) {
                    Log.d("Child iS: " , child.getKey());
                    if(child.getKey().trim().equalsIgnoreCase("Dishes")){
                        for (DataSnapshot dish : child.getChildren()) {
                            dishes_re.put(dish.getKey(),dish.getValue().toString());
                        }
                    }else if(child.getKey().trim().equalsIgnoreCase("Desserts")){
                        for (DataSnapshot dessert : child.getChildren()) {
                            dessert_re.put(dessert.getKey(),dessert.getValue().toString());
                        }
                    }
                }
                Log.d("HashMaps are: " , "desserts ->" + dessert_re.size() + " dishes ->" + dishes_re.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        dishesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int randomNumber = r.nextInt(dishes_re.size()-1);
                String[] hmapKeys = dishes_re.keySet().toString().replace("[", "").replace("]", "").trim().split(",");
                String choice = hmapKeys[randomNumber].trim();
                txt2.setText("Recipe: \n" + dishes_re.get(choice));
                txt2.setAllCaps(true);
                txt.setText(choice);
                txt.setAllCaps(true);
            }
        });

        dessertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int randomNumber = r.nextInt(dessert_re.size()-1);
                String[] hmapKeys = dessert_re.keySet().toString().replace("[", "").replace("]", "").trim().split(",");
                String choice = hmapKeys[randomNumber].trim();
                txt2.setText("Recipe: \n" + dessert_re.get(choice));
                txt2.setAllCaps(true);
                txt.setText(choice);
                txt.setAllCaps(true);
            }
        });
    }
}
