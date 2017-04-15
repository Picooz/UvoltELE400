package com.uvoltappoasis.uvoltappoasis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Page_charge extends AppCompatActivity {

    private Context mContext;
    private TextView mTextViewPercentage;
    private ProgressBar mProgressBar;
    private int mProgressStatus = 0;

    //Surplus en attendant d'avoir les vrais donnés
    private int mscale = 100;
    private int mlevel= 50;
    private EditText eText_level;
    private EditText eText_scale;
    private Button bouton;

    // Initialize a new BroadcastReceiver instance
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {


            // Recevoir la charge maximal
            int scale = mscale;//int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE,-1);

            // Recevoir le niveau de charge actuel
            int level = mlevel;//int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1);

            // Calculer le poucentage de batterie restante
            float percentage = level/ (float) scale;
            // Update the progress bar to display current battery charged percentage
            mProgressStatus = (int)((percentage)*100);

            // Afficher le pourcentage
            mTextViewPercentage.setText("Batterie restante: "+ mProgressStatus + "%");

            // Mise a jour de la barre de charge
            mProgressBar.setProgress(mProgressStatus);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request window feature action bar
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_charge);

        // Get the application context
        mContext = getApplicationContext();

        // Initialize a new IntentFilter instance
        IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);

        //Surplus en attendant d'avoir les vrais donnés
        eText_level = (EditText) findViewById(R.id.edittext_level);
        eText_scale = (EditText) findViewById(R.id.edittext_scale);
        bouton = (Button) findViewById(R.id.bouton_envoi);
        bouton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mlevel=Integer.parseInt(eText_level.getText().toString());
                mscale=Integer.parseInt(eText_scale.getText().toString());
            }
        });


        // Register the broadcast receiver
        mContext.registerReceiver(mBroadcastReceiver,iFilter);

        mTextViewPercentage = (TextView) findViewById(R.id.textview_percentage);
        mProgressBar = (ProgressBar) findViewById(R.id.barre_de_charge);
    }

}
