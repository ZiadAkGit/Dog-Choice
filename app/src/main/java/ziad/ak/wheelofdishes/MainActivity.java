package ziad.ak.wheelofdishes;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView2);
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        SeekBar seekBar = findViewById(R.id.seekBar1);
        txt.setText(R.string.Energy);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @SuppressLint("SetTextI18n")
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                choice = seekBar.getProgress() + 1;
                switch (count) {
                    case 0:
                        choices.add(choice);
                        txt.setText("All Good Click on the button in the bottom of the page");
                        count--;
                        break;
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Playfulness);
                        count--;
                        seekBar.setTransitionName("1-4");
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
                    //split the attributes to Text <-> Number
                    String[] dogVal = Objects.requireNonNull(dog.getValue()).toString().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
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
            if(choices.size() < 9){
                Toast.makeText(this, "Did you complete the quiz?", Toast.LENGTH_SHORT).show();
                return;
            }
            int[] User_choices = {choices.get(0), choices.get(1), choices.get(2), choices.get(3), choices.get(4),
                    choices.get(5), choices.get(6), choices.get(7), choices.get(8), choices.get(9)};

            for (int counter = 0; counter < dogS.size(); counter++) {
                //Getting all Dog Alt
                int[] Dog_choices = {Integer.parseInt(dogSS.get(counter)[13]), Integer.parseInt(dogSS.get(counter)[17]), Integer.parseInt(dogSS.get(counter)[3]),
                        Integer.parseInt(dogSS.get(counter)[15]), Integer.parseInt(dogSS.get(counter)[5]), Integer.parseInt(dogSS.get(counter)[7]), Integer.parseInt(dogSS.get(counter)[9]),
                        Integer.parseInt(dogSS.get(counter)[11]), Integer.parseInt(dogSS.get(counter)[1]), Integer.parseInt(dogSS.get(counter)[19])};

                int k = 0;
                //Check which are the best dogs for the choices.
                if ((Dog_choices[k] == User_choices[k] || (Dog_choices[k] + 1 == User_choices[k])
                        || (Dog_choices[k] - 1 == User_choices[k])))
                    if ((Dog_choices[k + 1] == User_choices[k + 1] || (Dog_choices[k + 1] + 1 == User_choices[k + 1])
                            || (Dog_choices[k + 1] - 1 == User_choices[k + 1])))
                        if ((Dog_choices[k + 2] == User_choices[k + 2] || (Dog_choices[k + 2] + 1 == User_choices[k + 2])
                                || (Dog_choices[k + 2] - 1 == User_choices[k + 2])))
                            if ((Dog_choices[k + 3] == User_choices[k + 3] || (Dog_choices[k + 3] + 1 == User_choices[k + 3])
                                    || (Dog_choices[k + 3] - 1 == User_choices[k + 3])))
                                if ((Dog_choices[k + 4] == User_choices[k + 4] || (Dog_choices[k + 4] + 1 == User_choices[k + 4])
                                        || (Dog_choices[k + 4] - 1 == User_choices[k + 4])))
                                    if ((Dog_choices[k + 5] == User_choices[k + 5] || (Dog_choices[k + 5] + 1 == User_choices[k + 5])
                                            || (Dog_choices[k + 5] - 1 == User_choices[k + 5])))
                                        if ((Dog_choices[k + 6] == User_choices[k + 6] || (Dog_choices[k + 6] + 1 == User_choices[k + 6])
                                                || (Dog_choices[k + 6] - 1 == User_choices[k + 6])))
                                            if ((Dog_choices[k + 7] == User_choices[k + 7] || (Dog_choices[k + 7] + 1 == User_choices[k + 7])
                                                    || (Dog_choices[k + 7] - 1 == User_choices[k + 7])))
                                                if ((Dog_choices[k + 8] == User_choices[k + 8] || (Dog_choices[k + 8] + 1 == User_choices[k + 8])
                                                        || (Dog_choices[k + 8] - 1 == User_choices[k + 8])))
                                                    if ((Dog_choices[k + 9] == User_choices[k + 9] || (Dog_choices[k + 9] + 1 == User_choices[k + 9])
                                                            || (Dog_choices[k + 9] - 1 == User_choices[k + 9])))
                                                        dogsToAdopt.add(dogSSS.get(counter));
            }

            if (dogsToAdopt.size() == 0){
                Log.d("Error: ", "Size = 0, No dogs were found");
                txt.setText("Sorry, We Couldn't find a dog that match those descriptions");
            }
            else {
                Random r = new Random();
                List<Integer> temp_check = new ArrayList<>();
                if (dogsToAdopt.size() <= 5) {
                    for (int x = 0; x < dogsToAdopt.size(); x++) {
                        String dogName = dogsToAdopt.get(x);
                        tempDogName += dogName + "\n";
                    }
                } else {
                    for (int z = 0; z < 5; z++) {
                        int random_choice = r.nextInt(dogsToAdopt.size());
                        temp_check.add(random_choice);
                        if(temp_check.contains(random_choice) && !(temp_check.get(0) == random_choice))
                            random_choice = r.nextInt(dogsToAdopt.size());
                        String dogName = dogsToAdopt.get(random_choice);
                        tempDogName += dogName + "\n";
                    }
                }
                txt.setText(tempDogName);
                count = 9;
                choices.clear();
            }
        });

        btn2.setOnClickListener(view -> {
            seekBar.clearFocus();
            seekBar.setProgress(0);
            MainActivity.this.recreate();
        });
    }
}