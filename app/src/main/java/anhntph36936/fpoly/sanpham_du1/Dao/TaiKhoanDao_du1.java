package anhntph36936.fpoly.sanpham_du1.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import anhntph36936.fpoly.sanpham_du1.Model.TaiKhoan_du1;
import anhntph36936.fpoly.sanpham_du1.MyDBHelper.DB_Helper;

public class TaiKhoanDao_du1 {
    DB_Helper hp_tk;



    public TaiKhoanDao_du1(Context context){
        hp_tk = new DB_Helper(context);
    }

    public boolean DangKiTK(TaiKhoan_du1 dto){
        SQLiteDatabase sqLiteDatabase = hp_tk.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("emailTK", dto.getEmailTK());
        values.put("userTK", dto.getUserTK());
        values.put("matKhau", dto.getMatKhau());
        values.put("laiMatKhau", dto.getLaiMatKhau());

        long check = sqLiteDatabase.insert("TaiKhoan", null, values);
            if (check != -1){
                return true;
            }
            return false;
    }


}
