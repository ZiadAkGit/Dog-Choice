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
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    int choice = 0;
    TextView txt;
    int count = 9;
    String tempDogName = "";
    List<Integer> choices = new ArrayList<>();
    HashMap<String, List<String[]>> dogS = new HashMap<>();
    List<String[]> dogSS = new ArrayList<>();
    List<String> dogSSS = new ArrayList<>();
    List<String> dogsToAdopt = new ArrayList<>();

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
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 1;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText("All Good Click on the button in the bottom of the page");
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Playfulness);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 8:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;

                    case 9:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
                choice = 0;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 2;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText("All Good Click on the button in the bottom of the page");
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Playfulness);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 8:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;

                    case 9:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
                choice = 0;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 3;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText("All Good Click on the button in the bottom of the page");
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Playfulness);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 8:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;

                    case 9:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
                choice = 0;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 4;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText("All Good Click on the button in the bottom of the page");
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Playfulness);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 8:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;

                    case 9:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
                choice = 0;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 5;
                switch (count){
                    case 0:
                        choices.add(choice);
                        txt.setText("All Good Click on the button in the bottom of the page");
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Playfulness);
                        count--;
                        break;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.adapt);
                        count--;
                        break;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                        break;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                        break;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                        break;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                        break;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                        break;
                    case 8:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                        break;

                    case 9:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                        break;
                }
                choice = 0;
            }
        });

        txt.setText(R.string.Energy);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dog : snapshot.getChildren()) {
                    //split the attributes to Text = Number
                    String[] dogVal = dog.getValue().toString().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                    //adding all dogs to hashmap with list of string array as a value
                    dogSS.add(dogVal);
                    dogS.put(dog.getKey(), dogSS);
                    dogSSS.add(dog.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int energy = choices.get(0);
                int ex = choices.get(1);
                int good = choices.get(2);
                int intes = choices.get(3);
                int sen = choices.get(4);
                int alone = choices.get(5);
                int cold = choices.get(6);
                int hot = choices.get(7);
                int adapt = choices.get(8);
                int playfulness = choices.get(9);
                for (int counter = 0; counter < dogS.size(); counter++){
                    int adaptDogs = Integer.parseInt(dogSS.get(counter)[1]);
                    int goodDogs = Integer.parseInt(dogSS.get(counter)[3]);
                    int senDogs = Integer.parseInt(dogSS.get(counter)[5]);
                    int coldDogs = Integer.parseInt(dogSS.get(counter)[9]);
                    int hotDogs = Integer.parseInt(dogSS.get(counter)[11]);
                    int energyDogs = Integer.parseInt(dogSS.get(counter)[13]);
                    int intesDogs = Integer.parseInt(dogSS.get(counter)[15]);
                    int exDogs = Integer.parseInt(dogSS.get(counter)[17]);
                    int aloneDogs = Integer.parseInt(dogSS.get(counter)[7]);
                    int playfulnessDogs = Integer.parseInt(dogSS.get(counter)[19]);
                    if(((energy == energyDogs) && (ex == exDogs) && (good == goodDogs) && (intes == intesDogs) &&
                            (sen == senDogs) && (alone == aloneDogs) && (cold == coldDogs) && (hot == hotDogs) &&
                            (adapt == adaptDogs) && (playfulness == playfulnessDogs)) ||
                            ((adaptDogs+1) == adapt) || (aloneDogs+1) == alone){
                        dogsToAdopt.add(dogSSS.get(counter));
                    }
                }
                Toast.makeText(MainActivity.this, "There are: " + dogsToAdopt.size() +" dogs that match", Toast.LENGTH_LONG).show();
                Random r = new Random();
                for (int z = 0; z < 5; z++) {
                    String dogName = dogsToAdopt.get(r.nextInt(dogsToAdopt.size()));
                    tempDogName += dogName + "\n";
                }
                txt.setText(tempDogName);
                count = 9;
                choices.clear();

            }
        });
    }
}