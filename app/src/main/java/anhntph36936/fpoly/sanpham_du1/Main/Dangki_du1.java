package anhntph36936.fpoly.sanpham_du1.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import anhntph36936.fpoly.sanpham_du1.Dao.TaiKhoanDao_du1;
import anhntph36936.fpoly.sanpham_du1.Model.TaiKhoan_du1;
import anhntph36936.fpoly.sanpham_du1.MyDBHelper.DB_Helper;
import anhntph36936.fpoly.sanpham_du1.R;

public class Dangki_du1 extends AppCompatActivity {
    EditText edEmailDK, edUserDK, edPassDK, edConfirmDK;
    Button btnTroveDK, btnDangkiDK;


    TaiKhoanDao_du1 dao_tk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki_du1);
        edEmailDK = findViewById(R.id.edEmailDK);
        edUserDK = findViewById(R.id.edUserDK);
        edPassDK = findViewById(R.id.edPassDK);
        edConfirmDK = findViewById(R.id.edConfirmDK);
        btnTroveDK = findViewById(R.id.btnTroveDK);
        btnDangkiDK = findViewById(R.id.btnDangkiDK);

        dao_tk = new TaiKhoanDao_du1(this);
        DB_Helper db_tk = new DB_Helper(this);
        db_tk.open();

        btnDangkiDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_dk = edEmailDK.getText().toString();
                String user_dk = edUserDK.getText().toString();
                String pass_dk = edPassDK.getText().toString();
                String confpass_dk = edConfirmDK.getText().toString();
                checkRong(edEmailDK);
                checkRong(edUserDK);
                checkRong(edPassDK);
                checkRong(edConfirmDK);

                if( !pass_dk.equals(confpass_dk)){
                    Toast.makeText(Dangki_du1.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                } else {
                    TaiKhoan_du1 dto = new TaiKhoan_du1();
                    dto.setEmailTK(email_dk);
                    dto.setUserTK(user_dk);
                    dto.setMatKhau(pass_dk);
                    dto.setLaiMatKhau(confpass_dk);
                    boolean check = dao_tk.DangKiTK(dto);
                    if(check){
                        Toast.makeText(Dangki_du1.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(Dangki_du1.this, "Đăng kí không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnTroveDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trove = new Intent(Dangki_du1.this, Dangnhap_du1.class);
                startActivity(trove);
                finish();
            }
        });
    }
    private boolean checkRong(EditText editText){
        if(editText.getText().toString().trim().length() > 0){
            return true;
        } else {
            editText.setError("Vui lòng không để trống !");
        }
        return  false;
    }


}