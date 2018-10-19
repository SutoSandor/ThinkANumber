package e.soola.thinkanumber;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView kep1;
    private TextView szam;
    private Button gomb_plusz;
    private Button gomb_minusz;
    private Button gomb_kuldes;
    private int x = 0;
    private Random rand = new Random();
    private int random = rand.nextInt(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        szam = (TextView) findViewById(R.id.szam);
        gomb_plusz = (Button) findViewById(R.id.gomb_plusz);
        gomb_minusz = (Button) findViewById(R.id.gomb_minusz);
        gomb_kuldes = (Button) findViewById(R.id.gomb_kuldes);
        kep1 = (ImageView) findViewById(R.id.sziv_1);
        gomb_plusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x<10) {
                    x++;
                    szam.setText(""+x);
                }
                else{

                    Context context = getApplicationContext();
                    CharSequence text = "Nem lehet nagyobb 10-nél!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        gomb_minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x>0){
                    x--;
                    szam.setText(""+x);
                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Nem lehet kisebb 0-nál!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        gomb_kuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x==random){
                    Context context = getApplicationContext();
                    CharSequence text = "NYERTÉL!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    gomb_kuldes.setEnabled(false);
                    finish();
                }
                if(x>random){
                    Context context = getApplicationContext();
                    kep1.setImageResource(R.drawable.heart1);
                    CharSequence text = "Kevesebb!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if(x<random){
                    Context context = getApplicationContext();
                    kep1.setImageResource(R.drawable.heart1);
                    CharSequence text = "Több!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}
