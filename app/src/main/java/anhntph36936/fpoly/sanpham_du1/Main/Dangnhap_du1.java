package anhntph36936.fpoly.sanpham_du1.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import anhntph36936.fpoly.sanpham_du1.R;

public class Dangnhap_du1 extends AppCompatActivity {
    EditText ededUserDN, edPassDN;
    CheckBox ckLuumk;
    Button btnDangnhapDN, btnDangkiDN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap_du1);
        ededUserDN = findViewById(R.id.edUserDN);
        edPassDN = findViewById(R.id.edPassDN);
        btnDangnhapDN = findViewById(R.id.btnDangnhapDN);
        btnDangkiDN = findViewById(R.id.btnDangkiDN);
        ckLuumk =  findViewById(R.id.cbLuumk);


        btnDangnhapDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent khachhang = new Intent(Dangnhap_du1.this, Khachhang_du1.class);
                startActivity(khachhang);
            }
        });
        btnDangkiDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dangki = new Intent(Dangnhap_du1.this, Dangki_du1.class);
                startActivity(dangki);
            }
        });
    }

}