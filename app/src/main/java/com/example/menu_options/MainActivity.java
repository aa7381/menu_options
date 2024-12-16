package com.example.menu_options;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {

    EditText firstnum , secnum ;
    TextView sum ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        firstnum = findViewById(R.id.firstnum);
        secnum = findViewById(R.id.secnum);
        sum = findViewById(R.id.sum);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem menu)
    {
        String num1 = firstnum.getText().toString();
        String num2 = secnum.getText().toString();

        if(num1.isEmpty() | num2.isEmpty() )
        {
            Toast.makeText(this, "pls enter the two num", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(menu);
        }
        else if(num1.equals("-")| num1.equals(".") | num1.equals("-.") |num1.equals("+") | num1.equals("+.") | num2.equals("-") |num2.equals(".") | num2.equals("-.") |num2.equals("+") | num2.equals("+."))
        {
            Toast.makeText(this, "wrong input pls enter only numbers", Toast.LENGTH_SHORT).show();
            return super.onOptionsItemSelected(menu);
        }
        double num11 = Double.parseDouble(num1);
        double num22 = Double.parseDouble(num2);
        double result = 0;

        int itemId = menu.getItemId();

        if (itemId == R.id.menuPlus) {
            result = num11 + num22;
        } else if (itemId == R.id.menuMinus) {
            result = num11 - num22;
        } else if (itemId == R.id.menuKefel) {
            result = num11 * num22;
        } else if (itemId == R.id.menuHiluk) {
            if (num22 != 0) {
                result = num11 / num22;
            } else {
                Toast.makeText(this, "a number cannot be divided by zero", Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(menu);
            }
        } else if (itemId == R.id.menuclear)
        {
            firstnum.setText("");
            secnum.setText("");
            sum.setText("");
            return true;
        }

        sum.setText(String.valueOf(result));
        return super.onOptionsItemSelected(menu);
    }
    }
