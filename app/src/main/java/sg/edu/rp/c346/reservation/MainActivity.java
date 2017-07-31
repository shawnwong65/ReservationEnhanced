package sg.edu.rp.c346.reservation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TimePicker tp;
    DatePicker dp;
    Button confirm;
    Button reset;
    CheckBox smoke;
    EditText etDate;
    EditText etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        confirm = (Button) findViewById(R.id.buttonConfirm);
        reset = (Button) findViewById(R.id.buttonReset);
        smoke = (CheckBox) findViewById(R.id.checkBoxSmoking);
        etDate = (EditText) findViewById(R.id.editTextDate);
        etTime = (EditText) findViewById(R.id.editTextTime);

        confirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text = "Time: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + " Date: " + dp.getDayOfMonth() + "/" + dp.getMonth() + "/" + dp.getYear();
                    Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

        reset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dp.updateDate(2017, 06, 01);
                tp.setCurrentHour(20);
                tp.setCurrentMinute(30);

            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        etDate.setHint("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };
                // Create the Date Picker Dialog
                Calendar now = Calendar.getInstance();
                int year = now.get(Calendar.YEAR);
                int month = now.get(Calendar.MONTH);
                int day = now.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year, month, day);

                myDateDialog.show();
            }

        });

        etTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Creating the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        etTime.setHint("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
                //TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                //myTimeListener, 20, 00, true);


                Calendar now = Calendar.getInstance();
                int hour = now.get(Calendar.HOUR_OF_DAY);
                int minute = now.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hour, minute, true);
                myTimeDialog.show();
            }
        });





    }
}
