package com.gordonzeng.numbershapes;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    public class Number {
        int num = 0;
        public boolean isSquare() {
            double result = Math.sqrt(num);
            if (result == (int) result) return true;
            else return false;
        }

        public boolean isTriangle() {
            if(num < 1) return false;
            int result = num;
            for (int i = 1; result > 0; i++)
                result -= i;
            if (result == 0) return true;
            else return false;
        }
    }

    Number number = new Number();

    public void clickFunction(View view) {
        EditText userInput = (EditText) findViewById(R.id.userInput);
        if(userInput.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), "Please enter a number!", Toast.LENGTH_SHORT).show();
            return;
        }
        int userNum = Integer.parseInt(userInput.getText().toString());
        number.num = userNum;
        String message = "";
        if (number.isSquare() && number.isTriangle()) message = "This number is both square and triangular!";
        else if (number.isSquare()) message = "This number is square!";
        else if (number.isTriangle()) message = "This number is triangular!";
        else message = "This number is neither square nor triangular!";

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
