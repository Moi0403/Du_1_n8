package anhntph36936.fpoly.sanpham_du1.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import anhntph36936.fpoly.sanpham_du1.Dao.DangNhapDao;
import anhntph36936.fpoly.sanpham_du1.Model.DangNhap;
import anhntph36936.fpoly.sanpham_du1.R;

public class Dangnhap_du1 extends AppCompatActivity {
    EditText ededUserDN, edPassDN;
    CheckBox cbLuumk;
    Button btnDangnhapDN, btnDangkiDN;
    DangNhapDao dangNhapDao;

    String name, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap_du1);

        btnDangnhapDN = findViewById(R.id.btnDangnhapDN);
        btnDangkiDN = findViewById(R.id.btnDangkiDN);
        ededUserDN = findViewById(R.id.edUserDN);
        edPassDN = findViewById(R.id.edPassDN);
        cbLuumk = findViewById(R.id.cbLuumk);
        dangNhapDao = new DangNhapDao(this);

        SharedPreferences preferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        String user = preferences.getString("USERNAME", "");
        String passw = preferences.getString("PASSWORD", "");
        Boolean rem = preferences.getBoolean("REMEMBER", false);


        ededUserDN.setText(user);
        edPassDN.setText(passw);
        cbLuumk.setChecked(rem);

        btnDangnhapDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = ededUserDN.getText().toString();
                pass = edPassDN.getText().toString();

                if(name.trim().isEmpty()||pass.trim().isEmpty())
                    Toast.makeText(Dangnhap_du1.this, "Bạn không được để trống!", Toast.LENGTH_SHORT).show();
                else{
                    if(dangNhapDao.checkLogin(name, pass) > 0){
                        Toast.makeText(Dangnhap_du1.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        remember(name, pass, cbLuumk.isChecked());
                        Intent intent  = new Intent(getApplicationContext(), Khachhang_du1.class);
                        intent.putExtra("user", "name");
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(Dangnhap_du1.this, "Thông tin không hợp lệ!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnDangkiDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dangnhap_du1.this, Dangki_du1.class));
                ededUserDN.setText("");
                edPassDN.setText("");
            }
        });






    }
    public void remember(String u, String p, boolean status) {
        SharedPreferences preferences = getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        if (!status) {
            editor.clear();
        } else {
            editor.putString("USERNAME", u);
            editor.putString("PASSWORD", p);
            editor.putBoolean("REMEMBER", status);

        }
        editor.commit();
    }


}