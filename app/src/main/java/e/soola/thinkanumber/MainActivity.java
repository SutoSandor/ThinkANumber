package e.soola.thinkanumber;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
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
    private ImageView kep2;
    private ImageView kep3;
    private ImageView kep4;
    private ImageView kep5;
    private TextView szam;
    private Button gomb_plusz;
    private Button gomb_minusz;
    private Button gomb_kuldes;
    private int x = 0;
    private Random rand = new Random();
    private int random = rand.nextInt(10);
    private int eletero = 5;
    private Button gomb_ujrakezd;
    private void ujrakezd(){
        kep1.setImageResource(R.drawable.heart2);
        kep2.setImageResource(R.drawable.heart2);
        kep3.setImageResource(R.drawable.heart2);
        kep4.setImageResource(R.drawable.heart2);
        kep5.setImageResource(R.drawable.heart2);
        random = rand.nextInt(10);
        gomb_kuldes.setEnabled(true);
        eletero = 5;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gomb_ujrakezd = (Button) findViewById(R.id.gomb_ujrakezd);
        szam = (TextView) findViewById(R.id.szam);
        gomb_plusz = (Button) findViewById(R.id.gomb_plusz);
        gomb_minusz = (Button) findViewById(R.id.gomb_minusz);
        gomb_kuldes = (Button) findViewById(R.id.gomb_kuldes);
        kep1 = (ImageView) findViewById(R.id.sziv_1);
        kep2 = (ImageView) findViewById(R.id.sziv_2);
        kep3 = (ImageView) findViewById(R.id.sziv_3);
        kep4 = (ImageView) findViewById(R.id.sziv_4);
        kep5 = (ImageView) findViewById(R.id.sziv_5);
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

                    CharSequence text = "Kevesebb!";
                    int duration = Toast.LENGTH_SHORT;
                    eletero--;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                if(x<random){
                    Context context = getApplicationContext();

                    CharSequence text = "Több!";
                    int duration = Toast.LENGTH_SHORT;
                    eletero--;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                switch (eletero){
                    case 4: kep1.setImageResource(R.drawable.heart1); break;
                    case 3: kep2.setImageResource(R.drawable.heart1); break;
                    case 2: kep3.setImageResource(R.drawable.heart1); break;
                    case 1: kep4.setImageResource(R.drawable.heart1); break;
                    case 0: kep5.setImageResource(R.drawable.heart1);
                            gomb_kuldes.setEnabled(false);break;
                }
            }
        });
        gomb_ujrakezd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ujrakezd();
            }
        });

    }
}
