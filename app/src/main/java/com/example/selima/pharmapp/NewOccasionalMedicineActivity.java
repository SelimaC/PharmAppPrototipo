package com.example.selima.pharmapp;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;

public class NewOccasionalMedicineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_occasional_medicine);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.newOccasionalMedicine);

        EditText name = (EditText) findViewById(R.id.nameOccasionalMedicine);

        /*NumberPicker amount = (NumberPicker) findViewById(R.id.amount);
        amount.setMinValue(0);
        amount.setMaxValue(10);
        amount.setWrapSelectorWheel(true);*/



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
