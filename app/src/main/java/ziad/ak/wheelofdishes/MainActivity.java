package ziad.ak.wheelofdishes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
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
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    int choice = 0;
    TextView txt;
    int count = 9;
    String tempDogName = "";
    List<Integer> choices = new ArrayList<>();
    Map<String, List<String[]>> dogS = new HashMap<>();
    List<String[]> dogSS = new ArrayList<>();
    List<String> dogSSS = new ArrayList<>();
    List<String> dogsToAdopt = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView2);
        Button btn1 = findViewById(R.id.button);
        SeekBar seekBar = findViewById(R.id.seekBar1);

        txt.setText(R.string.Energy);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                choice = seekBar.getProgress();
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
            }
        });

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

        btn1.setOnClickListener(view -> {
            int energy = choices.get(0); int ex = choices.get(1); int good = choices.get(2); int intes = choices.get(3); int sen = choices.get(4);
            int alone = choices.get(5); int cold = choices.get(6); int hot = choices.get(7); int adapt = choices.get(8); int playfulness = choices.get(9);

            for (int counter = 0; counter < dogS.size(); counter++){
                //Getting all Dog Alt
                int adaptDogs = Integer.parseInt(dogSS.get(counter)[1]); int goodDogs = Integer.parseInt(dogSS.get(counter)[3]);
                int senDogs = Integer.parseInt(dogSS.get(counter)[5]); int aloneDogs = Integer.parseInt(dogSS.get(counter)[7]);
                int coldDogs = Integer.parseInt(dogSS.get(counter)[9]); int hotDogs = Integer.parseInt(dogSS.get(counter)[11]);
                int energyDogs = Integer.parseInt(dogSS.get(counter)[13]); int intesDogs = Integer.parseInt(dogSS.get(counter)[15]);
                int exDogs = Integer.parseInt(dogSS.get(counter)[17]); int playfulnessDogs = Integer.parseInt(dogSS.get(counter)[19]);
                //Checking who is the best match
                if(((energy == energyDogs) && (ex == exDogs) && (good == goodDogs) && (intes == intesDogs) &&
                        (sen == senDogs) && (alone == aloneDogs) && (cold == coldDogs) && (hot == hotDogs) &&
                        (adapt == adaptDogs) && (playfulness == playfulnessDogs)) ||
                        ((energy == energyDogs) && (ex == exDogs) && (good == goodDogs) && (intes == intesDogs) &&
                                (sen == senDogs) && (alone == aloneDogs) && (cold == coldDogs) && (hot == hotDogs) &&
                                (adapt + 1 == adaptDogs) && (playfulness + 1 == playfulnessDogs)) ||
                        ((energy + 1 == energyDogs) && (ex == exDogs) && (good + 1== goodDogs) && (intes == intesDogs) &&
                                (sen == senDogs) && (alone == aloneDogs) && (cold == coldDogs) && (hot == hotDogs) &&
                                (adapt == adaptDogs) && (playfulness == playfulnessDogs))   ){
                    dogsToAdopt.add(dogSSS.get(counter));
                }
            }
            //Log.d("DogLIST: " , "There are: " + dogsToAdopt.size() +" dogs that match");
            Random r = new Random();
            int tempcheck = 0;
            for (int z = 0; z < 5; z++) {
                int randomchoice = r.nextInt(dogsToAdopt.size());
                if (tempcheck != randomchoice) {
                    String dogName = dogsToAdopt.get(randomchoice);
                    tempDogName += dogName + "\n";
                }
                tempcheck = randomchoice;
            }
            txt.setText(tempDogName);
            count = 9;
            choices.clear();
        });
    }
}