package com.example.logic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtSoA: EditText = findViewById(R.id.edt_soA)
        val edtSoB: EditText = findViewById(R.id.edt_soB)
        val edtSoC: EditText = findViewById(R.id.edt_soC)
        val btnSolve: Button = findViewById(R.id.btn_solve)
        val btnReset: Button = findViewById(R.id.btn_reset)
        val btnClose: Button = findViewById(R.id.btn_close)
        val txtAns: TextView = findViewById(R.id.txt_Ans)

        btnSolve.setOnClickListener {

            var a = edtSoA.text.toString().toDouble()
            var b = edtSoB.text.toString().toDouble()
            var c = edtSoC.text.toString().toDouble()

            fun solve( a:Double, b:Double, c:Double)
            {
                var denta: Double = b * b - 4 * a * c

                if ( denta > 0 )
                {
                    var x1 = ( -b + Math.sqrt(denta) ) / ( 2 * a )
                    var x2 = ( -b - Math.sqrt(denta) ) / ( 2 * a )
                    txtAns.setText( txtAns.text.toString() + "Phương trình có 2 nghiệm phân biệt: x1 = " + x1 + " ; x2 = " + x2 )
                }
                else if ( denta == 0.0 )
                {
                    var x = -b / ( 2 * a )
                    txtAns.setText( txtAns.text.toString() + "Phương trình có 1 nghiệm duy nhất x1 = x2 = " + x )
                }
                else
                {
                    txtAns.setText( txtAns.text.toString() + "Phương trình vô nghiệm!")
                }
            }

            solve( a, b, c )

        }

        btnReset.setOnClickListener {
            edtSoA.setText("")
            edtSoB.setText("")
            edtSoC.setText("")
            txtAns.setText("")
        }

        btnClose.setOnClickListener {
            finish()
        }




    }
}