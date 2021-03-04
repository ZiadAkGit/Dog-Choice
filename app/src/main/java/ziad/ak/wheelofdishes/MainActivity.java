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
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
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
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
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
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
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
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
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
                    case 1:
                        choices.add(choice);
                        txt.setText(R.string.Hot);
                        count--;
                    case 2:
                        choices.add(choice);
                        txt.setText(R.string.Cold);
                        count--;
                    case 3:
                        choices.add(choice);
                        txt.setText(R.string.lonelyness);
                        count--;
                    case 4:
                        choices.add(choice);
                        txt.setText(R.string.Sensitivity);
                        count--;
                    case 5:
                        choices.add(choice);
                        txt.setText(R.string.Intensity);
                        count--;
                    case 6:
                        choices.add(choice);
                        txt.setText(R.string.good);
                        count--;
                    case 7:
                        choices.add(choice);
                        txt.setText(R.string.Exercise);
                        count--;
                }
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count == 0) {
                    myRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot dog : snapshot.getChildren()) {
                                String dogName = dog.getKey();
                                for (DataSnapshot dogAttributes : dog.getChildren()) {
                                    String attribute = dogAttributes.getKey();
                                    String attributeValue = (String) dogAttributes.getValue();

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
