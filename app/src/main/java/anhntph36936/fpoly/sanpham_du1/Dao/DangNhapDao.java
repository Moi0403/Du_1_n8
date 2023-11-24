package anhntph36936.fpoly.sanpham_du1.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import anhntph36936.fpoly.sanpham_du1.Model.DangNhap;
import anhntph36936.fpoly.sanpham_du1.MyDBHelper.DB_Helper;

public class DangNhapDao {
    private static SQLiteDatabase db;

    public DangNhapDao(Context context) {
        DB_Helper db_helper = new DB_Helper(context);
        db = db_helper.getWritableDatabase();
    }




    public long insert(DangNhap obj){
        ContentValues values = new ContentValues();
        values.put("maTT", obj.getMaTT());
        values.put("hoTen", obj.getHoten());
        values.put("matKhau", obj.getMatkhau());
        return db.insert("DangNhap", null, values);
    }
    public int updatePass(DangNhap obj){
        ContentValues values = new ContentValues();
        values.put("hoTen", obj.getHoten());
        values.put("matKhau", obj.getMatkhau());
        return db.update("DangNhap", values, "maTT=?", new String[]{obj.getMaTT()});
    }
    public int delete(String id){
        return db.delete("ThuThu", "maTT=?", new String[]{id});
    }

    @SuppressLint("Range")
    public static List<DangNhap> getData(String sql, String... selectionArgs){
        List<DangNhap> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()){
            DangNhap obj = new DangNhap();
            obj.setMaTT(cursor.getString(cursor.getColumnIndex("maTT")));
            obj.setHoten(cursor.getString(cursor.getColumnIndex("hoTen")));
            obj.setMatkhau(cursor.getString(cursor.getColumnIndex("matKhau")));

            list.add(obj);
        }
        return list;
    }
    // get tat ca data
    public List<DangNhap> getAll(){
        String sql = "SELECT * FROM DangNhap";
        return getData(sql);
    }
    //get daât theo id
    public DangNhap getID (String id){
        String sql = "SELECT * FROM DangNhap WHERE maTT= ?";
        List<DangNhap> list = getData(sql, id);
        return list.get(0);
    }
    public static int checkLogin(String id, String password){
        String sql = "SELECT * FROM DangNhap WHERE maTT=? AND matKhau=?";
        List<DangNhap> list = getData(sql, id ,password);
        if (list.size() == 0 ) return -1;
        return 1;
    }

}
