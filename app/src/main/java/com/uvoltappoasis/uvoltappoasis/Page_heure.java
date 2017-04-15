package com.uvoltappoasis.uvoltappoasis;

        import android.os.Build;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TimePicker;
        import android.widget.Toast;

public class Page_heure extends AppCompatActivity {

    private TimePicker timePicker1;
    private int hour;
    private int min;
    private int am_pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_heure);

        Button button = (Button)findViewById(R.id.envoi_heure);
        timePicker1 = (TimePicker) findViewById(R.id.heure);
        timePicker1.setIs24HourView(false);
        // Show toast message when button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= 23 ) {
                    hour = timePicker1.getHour();
                    min = timePicker1.getMinute();
                }
                else {
                    hour = timePicker1.getCurrentHour();
                    min = timePicker1.getCurrentMinute();
                }
                if (hour >= 12) {
                    am_pm=1;//Apres-midi
                    Toast.makeText(getApplicationContext(), hour - 12 + "h:" + min + "min PM", Toast.LENGTH_LONG).show();
                }
                else {
                    am_pm=0;//Avant-midi
                    Toast.makeText(getApplicationContext(), hour + "h:" + min + "min AM", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}
