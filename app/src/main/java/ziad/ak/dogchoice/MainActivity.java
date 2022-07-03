package ziad.ak.dogchoice;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    int choice = 0;
    TextView txt, txtX, txtY;
    int count = 9;
    String publishedString = "";
    List<Integer> choices_Values = new ArrayList<>();
    List<String> choices_Names = new ArrayList<>();
    Map<String, List<String[]>> dogS = new HashMap<>();
    List<String[]> dogSS = new ArrayList<>();
    List<String> dogSSS = new ArrayList<>();
    List<String> largerThan70 = new ArrayList<>();
    List<String> smallerThan70 = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap, final boolean order) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView2);
        txtX = findViewById(R.id.txtviewX);
        txtY = findViewById(R.id.txtviewY);
        Button result_btn = findViewById(R.id.button);
        Button reset_btn = findViewById(R.id.button2);
        SeekBar seekBar = findViewById(R.id.seekBar1);
        txt.setText(R.string.Energy);
        txtX.setText("Loves it's bed");
        txtY.setText("Very energetic");

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
                        choices_Values.add(choice);
                        choices_Names.add("Playfulness");
                        txt.setText("Click Results button to know your dogs of choice");
                        seekBar.setVisibility(View.INVISIBLE);
                        txtX.setVisibility(View.INVISIBLE);
                        txtY.setVisibility(View.INVISIBLE);
                        count--;
                        break;
                    case 1:
                        choices_Values.add(choice);
                        choices_Names.add("small house");
                        txt.setText(R.string.Playfulness);
                        txtX.setText("Not Playful at all");
                        txtY.setText("Very Playful");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 2:
                        choices_Values.add(choice);
                        choices_Names.add("Hot Weather");
                        txt.setText(R.string.adapt);
                        txtX.setText("Doesn't adapt at all");
                        txtY.setText("Adapts very well");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 3:
                        choices_Values.add(choice);
                        choices_Names.add("Cold weather");
                        txt.setText(R.string.Hot);
                        txtX.setText("Doesn't tolerate at all");
                        txtY.setText("Love hot weather");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 4:
                        choices_Values.add(choice);
                        choices_Names.add("Loneliness");
                        txt.setText(R.string.Cold);
                        txtX.setText("Doesn't tolerate at all");
                        txtY.setText("Love cold weather");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 5:
                        choices_Values.add(choice);
                        choices_Names.add("Sensitivity");
                        txt.setText(R.string.lonelyness);
                        txtX.setText("Hate to be lonely");
                        txtY.setText("Love being lonely");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 6:
                        choices_Values.add(choice);
                        choices_Names.add("Intensity");
                        txt.setText(R.string.Sensitivity);
                        txtX.setText("Cold hearted");
                        txtY.setText("Drama queen");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 7:
                        choices_Values.add(choice);
                        choices_Names.add("New to dogs");
                        txt.setText(R.string.Intensity);
                        txtX.setText("Not intense at all");
                        txtY.setText("Very intense");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 8:
                        choices_Values.add(choice);
                        choices_Names.add("Exercise needed");
                        txt.setText(R.string.good);
                        txtX.setText("Not new at all");
                        txtY.setText("Just started");
                        seekBar.setProgress(0);
                        count--;
                        break;
                    case 9:
                        choices_Values.add(choice);
                        choices_Names.add("Energy needed");
                        txt.setText(R.string.Exercise);
                        txtX.setText("I love my Snorlax");
                        txtY.setText("BEAST MODE ON");
                        seekBar.setProgress(0);
                        count--;
                        break;
                }
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dog : snapshot.getChildren()) {
                    String[] dogVal = Objects.requireNonNull(dog.getValue()).toString().split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
                    dogSS.add(dogVal);
                    dogS.put(dog.getKey(), dogSS);
                    dogSSS.add(dog.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        result_btn.setOnClickListener(view -> {
            if (choices_Values.size() <= 9) {
                Toast.makeText(this, "Did you complete the quiz?", Toast.LENGTH_SHORT).show();
                return;
            }

            for (int K = 0; K < choices_Names.size(); K++) {
                Log.d(choices_Names.get(K), String.valueOf(choices_Values.get(K)));
            }

            int[] User_choices = {choices_Values.get(0), choices_Values.get(1), choices_Values.get(2), choices_Values.get(3), choices_Values.get(4),
                    choices_Values.get(5), choices_Values.get(6), choices_Values.get(7), choices_Values.get(8), choices_Values.get(9)};

            Map<String, Integer> chances = new HashMap<>();

            for (int counter = 0; counter < dogS.size(); counter++) {
                //Getting all Dog Alt
                int[] Dog_choices = {Integer.parseInt(dogSS.get(counter)[13]), Integer.parseInt(dogSS.get(counter)[17]), Integer.parseInt(dogSS.get(counter)[3]),
                        Integer.parseInt(dogSS.get(counter)[15]), Integer.parseInt(dogSS.get(counter)[5]), Integer.parseInt(dogSS.get(counter)[7]), Integer.parseInt(dogSS.get(counter)[9]),
                        Integer.parseInt(dogSS.get(counter)[11]), Integer.parseInt(dogSS.get(counter)[1]), Integer.parseInt(dogSS.get(counter)[19])};

                //int for check and %
                int cCheck = 0;
                //Check which are the best dogs for the choices.
                if (Dog_choices[0] == User_choices[0])
                    cCheck += 10;
                else if (Dog_choices[0] + 1 == User_choices[0])
                    cCheck += 5;
                else if (Dog_choices[0] - 1 == User_choices[0])
                    cCheck += 4;

                if (Dog_choices[1] == User_choices[1])
                    cCheck += 10;
                else if (Dog_choices[1] + 1 == User_choices[1])
                    cCheck += 5;
                else if (Dog_choices[1] - 1 == User_choices[1])
                    cCheck += 4;

                if (Dog_choices[2] == User_choices[2])
                    cCheck += 10;
                else if (Dog_choices[2] + 1 == User_choices[2])
                    cCheck += 5;
                else if (Dog_choices[2] - 1 == User_choices[2])
                    cCheck += 4;

                if (Dog_choices[3] == User_choices[3])
                    cCheck += 10;
                else if (Dog_choices[3] + 1 == User_choices[3])
                    cCheck += 5;
                else if (Dog_choices[3] - 1 == User_choices[3])
                    cCheck += 4;

                if (Dog_choices[4] == User_choices[4])
                    cCheck += 10;
                else if (Dog_choices[4] + 1 == User_choices[4])
                    cCheck += 5;
                else if (Dog_choices[4] - 1 == User_choices[4])
                    cCheck += 4;

                if (Dog_choices[5] == User_choices[5])
                    cCheck += 10;
                else if (Dog_choices[5] + 1 == User_choices[5])
                    cCheck += 5;
                else if (Dog_choices[5] - 1 == User_choices[5])
                    cCheck += 4;

                if (Dog_choices[6] == User_choices[6])
                    cCheck += 10;
                else if (Dog_choices[6] + 1 == User_choices[6])
                    cCheck += 5;
                else if (Dog_choices[6] - 1 == User_choices[6])
                    cCheck += 4;

                if (Dog_choices[7] == User_choices[7])
                    cCheck += 10;
                else if (Dog_choices[7] + 1 == User_choices[7])
                    cCheck += 5;
                else if (Dog_choices[7] - 1 == User_choices[7])
                    cCheck += 4;

                if (Dog_choices[8] == User_choices[8])
                    cCheck += 10;
                else if (Dog_choices[8] + 1 == User_choices[8])
                    cCheck += 5;
                else if (Dog_choices[8] - 1 == User_choices[8])
                    cCheck += 4;

                if (Dog_choices[9] == User_choices[9])
                    cCheck += 10;
                else if (Dog_choices[9] + 1 == User_choices[9])
                    cCheck += 5;
                else if (Dog_choices[9] - 1 == User_choices[9])
                    cCheck += 4;

                if (cCheck >= 70)
                    largerThan70.add(dogSSS.get(counter));
                else
                    smallerThan70.add(dogSSS.get(counter));

                chances.put(dogSSS.get(counter), cCheck);
            }

            Log.d("CheckdogSSS", "The size is: " + dogSSS.size());

            if (largerThan70.size() == 0 && smallerThan70.size() == 0) {
                Log.d("SIZE ", "0, No dogs were found");
                txt.setText("Sorry, At this time we Couldn't find any dogs that match these descriptions\nClick Reset button to start again!");
            } else {
                publishedString = "The top dogs for you are:\n\n";
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    chances = sortByValue(chances, false);
                }

                if (largerThan70.size() >= 5) {
                    List<String> dogsSorted = new ArrayList<>(chances.keySet());
                    for (int i = 0; i < 5; i++)
                        publishedString += dogsSorted.get(i) + " with " + chances.get(dogsSorted.get(i)) + "% chances\n";

                    txt.setText(publishedString);
                    count = 9;
                    choices_Values.clear();
                    choices_Names.clear();
                } else {
                    if (smallerThan70.size() >= 5) {
                        List<String> dogsSorted = new ArrayList<>(chances.keySet());
                        for (int i = 0; i < 5; i++)
                            publishedString += chances.get(dogsSorted.get(i)) + "% - " + dogsSorted.get(i) + "%\n";

                        txt.setText(publishedString);
                        count = 9;
                        choices_Values.clear();
                        choices_Names.clear();
                    } else
                        for (String s : largerThan70)
                            publishedString += s;
                }
            }
            result_btn.setVisibility(View.INVISIBLE);
        });

        reset_btn.setOnClickListener(view -> {
            seekBar.clearFocus();
            seekBar.setProgress(0);
            MainActivity.this.recreate();
        });
    }
}