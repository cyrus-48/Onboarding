//package com.example.onboarding;
////
////import android.os.Bundle;
////
////import androidx.fragment.app.Fragment;
////
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////
/////**
//// * A simple {@link Fragment} subclass.
//// * Use the {@link Scan#newInstance} factory method to
//// * create an instance of this fragment.
//// */
////public class Scan extends Fragment {
////
////    // TODO: Rename parameter arguments, choose names that match
////    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
////    private static final String ARG_PARAM1 = "param1";
////    private static final String ARG_PARAM2 = "param2";
////
////    // TODO: Rename and change types of parameters
////    private String mParam1;
////    private String mParam2;
////
////    public Scan() {
////        // Required empty public constructor
////    }
////
////    /**
////     * Use this factory method to create a new instance of
////     * this fragment using the provided parameters.
////     *
////     * @param param1 Parameter 1.
////     * @param param2 Parameter 2.
////     * @return A new instance of fragment Scan.
////     */
////    // TODO: Rename and change types and number of parameters
////    public static Scan newInstance(String param1, String param2) {
////        Scan fragment = new Scan();
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, param1);
////        args.putString(ARG_PARAM2, param2);
////        fragment.setArguments(args);
////        return fragment;
////    }
////
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
////    }
////
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.fragment_scan, container, false);
////    }
////}
//
//import android.Manifest;
//import android.annotation.SuppressLint;
//import android.content.pm.PackageManager;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.Toast;
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;
//import androidx.core.content.ContextCompat;
//
//import com.google.zxing.ResultPoint;
//import com.journeyapps.barcodescanner.DecoratedBarcodeView;
//import com.journeyapps.barcodescanner.BarcodeCallback;
//import com.journeyapps.barcodescanner.BarcodeResult;
//import java.util.List;
//public class ScannerActivity extends AppCompatActivity {
//    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
//    private DecoratedBarcodeView barcodeView;
//    private String barcodeValue;
//
//    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_scan);barcodeView = findViewById(R.id.btn_scan);
//// Check and request camera permission
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                    new String[]{Manifest.permission.CAMERA},
//                    CAMERA_PERMISSION_REQUEST_CODE);
//        } else {
//            startScanning();
//        }
//    }
//    private void startScanning() {
//        barcodeView.decodeContinuous(new BarcodeCallback() {
//            @Override
//            public void barcodeResult(BarcodeResult result) {
//// Process barcode result
//                String barcodeValue = result.getText();
//                Log.d("Barcode", "Scanned: " + barcodeValue);
//// Fetch drug details based on the scanned barcodeValue
//                fetchDrugDetails(barcodeValue);
//            }
//
//            private void fetchDrugDetails(String barcodeValue) {
//            }
//
//            @Override
//            public void possibleResultPoints(List<ResultPoint> resultPoints) {
//// Ignored}
//            };
//        });
//        private void fetchDrugDetails;(String barcodeValue;{
//// Implement logic to fetch drug details from database or API
//// This could involve making a network request and parsing the response
//// For demonstration, we'll just display a toast with the scanned barcode value
//            runOnUiThread(() -> Toast.makeText(ScannerActivity.this, "Scanned: " + barcodeValue,
//                    Toast.LENGTH_SHORT).show());
//        }
//
//        @Override
//        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//        @NonNull int[] grantResults) {
//            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//            if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
//                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    startScanning();// Permission granted, start scanning
//
//                } else {
//// Permission denied, show message or handle accordingly
//                    Toast.makeText(this, "Camera Manifest.permission required to scan",
//                            Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//            }
//        }
//    }}