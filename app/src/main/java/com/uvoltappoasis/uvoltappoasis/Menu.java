package com.uvoltappoasis.uvoltappoasis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void ButtonVersHeure(View v) {
        //Va a la page des heures lorsque le bouton est utiliser
        Intent Intent = new Intent(Menu.this, Page_heure.class);
        Menu.this.startActivity(Intent);
    }

    public void ButtonVersCharge(View v) {
        //Va a la page de la charge lorsque le bouton est utiliser
        Intent Intent = new Intent(Menu.this, Page_charge.class);
        Menu.this.startActivity(Intent);
    }

    public void ButtonVersBluetooth(View v) {
        //Va a la page de la charge lorsque le bouton est utiliser
        Intent Intent = new Intent(Menu.this, Bluetooth_co.class);
        Menu.this.startActivity(Intent);
    }

}
