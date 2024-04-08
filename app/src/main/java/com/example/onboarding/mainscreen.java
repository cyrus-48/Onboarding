package com.example.onboarding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class mainscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        // Initialize the button for scanning
        findViewById(R.id.btn_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the QR code scanning process
                startQRCodeScanner();
            }
        });
    }

    // Method to start the QR code scanner
    private void startQRCodeScanner() {
        try {
            IntentIntegrator integrator = new IntentIntegrator(this);
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
            integrator.setPrompt("Scan a QR Code");
            integrator.setCameraId(0);  // Use a specific camera of the device
            integrator.setBeepEnabled(false);
            integrator.setBarcodeImageEnabled(true);
            integrator.initiateScan();
        } catch (ActivityNotFoundException ex) {
            Log.e("mainscreen", "Scanner Not Found", ex);
        }
    }

    // Handle the result of the QR code scanning process
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                // QR code scanning was canceled
                Toast.makeText(this, "Scan was Cancelled", Toast.LENGTH_LONG).show();
            } else {
                // QR code was successfully scanned, handle the result here
                String contents = result.getContents();
                Toast.makeText(this, "Scanned content: " + contents, Toast.LENGTH_LONG).show();
                // You can further process the scanned content here
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
