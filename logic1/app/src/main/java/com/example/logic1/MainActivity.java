package com.example.logic1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtSoA, edtSoB, edtSoC;

    Button btnSolve, btnReset, btnClose;

    TextView txtAns;

    double a = 0, b = 0, c = 0, ans ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        btnSolve.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a = Double.parseDouble( edtSoA.getText() + "");
                        b = Double.parseDouble( edtSoB.getText() + "");
                        c = Double.parseDouble( edtSoC.getText() + "");

                        double x1, x2, denta = b*b - 4*a*c;

                        if ( denta > 0 )
                        {
                            x1 =( -b + Math.sqrt(denta) ) / (2*a) ;
                            x2 =( -b - Math.sqrt(denta) ) / (2*a) ;
                            txtAns.setText("x1 = " + x1 + " ; x2 = " + x2);
                        } else if ( denta == 0 ) {
                            x1 = -b / ( 2 * a ) ;
                            txtAns.setText("x1 = x2 = " + x1);
                            
                        }
                        else
                        {
                            txtAns.setText("PT vô nghiệm");
                        }
                    }
                }
        );

        btnReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtSoA.setText("");
                        edtSoB.setText("");
                        edtSoC.setText("");
                        txtAns.setText("");
                    }
                }
        );

        btnClose.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );


    }

    public void anhXa()
    {
        edtSoA = findViewById(R.id.edt_soA);
        edtSoB= findViewById(R.id.edt_soB);
        edtSoC = findViewById(R.id.edt_soC);
        btnClose = findViewById(R.id.btn_close);
        btnReset = findViewById(R.id.btn_reset);
        btnSolve = findViewById(R.id.btn_solve);
        txtAns = findViewById(R.id.txt_Ans);
    }
}