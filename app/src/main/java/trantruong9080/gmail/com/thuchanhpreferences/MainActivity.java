package trantruong9080.gmail.com.thuchanhpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtnumber;
    Button btn_black, btn_red, btn_bue, btn_green, btn_count, btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("datanumber", Context.MODE_PRIVATE);
        txtnumber = findViewById(R.id.tvnumber);
        btn_black = findViewById(R.id.btn_black);
        btn_red =  findViewById(R.id.btn_red);
        btn_bue = findViewById(R.id.btn_blue);
        btn_green = findViewById(R.id.btn_green);
        btn_count = findViewById(R.id.btn_count);
        btn_reset = findViewById(R.id.btn_reset);

        int number1 = sharedPreferences.getInt("count",0);
            txtnumber.setText(""+number1);

        int color = sharedPreferences.getInt("color", 0);
        txtnumber.setBackgroundColor(color);

        btn_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int  mcount = Integer.parseInt(txtnumber.getText().toString());
                if(mcount >= 0){
                    mcount  = mcount +1;
                    txtnumber.setText(""+mcount);
                }
                else {
                    Toast.makeText(MainActivity.this,"Fail", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnumber.setBackgroundColor(getResources().getColor(R.color.green));

            }
        });
        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnumber.setBackgroundColor(getResources().getColor(R.color.red));

            }
        });
        btn_bue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnumber.setBackgroundColor(getResources().getColor(R.color.blue));

            }
        });
        btn_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnumber.setBackgroundColor(getResources().getColor(R.color.black));

            }
        });
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                txtnumber.setText(""+0);
                txtnumber.setBackgroundColor(getResources().getColor(R.color.gray));
                editor.apply();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("datanumber", Context.MODE_PRIVATE);
        int mcount = Integer.parseInt(txtnumber.getText().toString());
        int color = ((ColorDrawable) txtnumber.getBackground()).getColor();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count",mcount);
        editor.putInt("color",color);
        editor.apply();
    }
}