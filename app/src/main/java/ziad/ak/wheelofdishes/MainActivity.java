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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    int count = 7;
    int choice = 0;
    List<Integer> choices = new ArrayList<Integer>();;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView2);
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button6);
        Button btn5 = findViewById(R.id.button5);
        Button btn6 = findViewById(R.id.button4);
        txt.setText(R.string.Energy);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 1;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 2;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 3;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 4;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 5;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count <= 0) {
                    String tempDogName;
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //For each dog in the list
                            for (DataSnapshot dog : snapshot.getChildren()) {
                                String dogName = dog.getKey();
                                //put all values in a list to compare
                                List<String> list = new ArrayList<>();
                                for (DataSnapshot dog2:dog.getChildren()) {
                                    list.add((String) dog2.getValue());
                                }
                                //all user choices.
                                String energy = String.valueOf(choices.get(0));
                                String ex = String.valueOf(choices.get(1));
                                String good = String.valueOf(choices.get(2));
                                String sen = String.valueOf(choices.get(3));
                                String alone = String.valueOf(choices.get(4));
                                String cold = String.valueOf(choices.get(5));
                                String hot = String.valueOf(choices.get(6));
                                String adapt = String.valueOf(choices.get(7));
                                if(energy.equalsIgnoreCase(list.get(0)) && ex.equalsIgnoreCase(list.get(1)) && good.equalsIgnoreCase(list.get(2))
                                        && sen.equalsIgnoreCase(list.get(3)) && alone.equalsIgnoreCase(list.get(4)) && cold.equalsIgnoreCase(list.get(5))
                                        && hot.equalsIgnoreCase(list.get(6)) && adapt.equalsIgnoreCase(list.get(7))){
                                    Toast.makeText(MainActivity.this, "You Are a " + dogName + " DOG!", Toast.LENGTH_LONG).show();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this, "Please Answer ALL QUESTIONS!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
