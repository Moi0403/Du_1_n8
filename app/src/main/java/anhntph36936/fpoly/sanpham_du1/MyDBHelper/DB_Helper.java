package anhntph36936.fpoly.sanpham_du1.MyDBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Helper extends SQLiteOpenHelper {

    static String DB_NAME = "Da1_n8";
    static  int DB_VERSION = 7;

    public DB_Helper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // bảng tài khoản
        String tb_TaiKhoan = "CREATE TABLE TaiKhoan (" +
                "maTK INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "emailTK TEXT NOT NULL, " +
                "userTK TEXT NOT NULL," +
                "matKhau TEXT NOT NULL," +
                "laiMatKhau TEXT NOT NULL)";
        db.execSQL(tb_TaiKhoan);

        String db_DangNhap=
                "CREATE TABLE DangNhap (" +
                        "maTT TEXT PRIMARY KEY, " +
                        "hoTen TEXT NOT NULL, " +
                        "matKhau TEXT NOT NULL)";
        db.execSQL(db_DangNhap);

        String tb_taikhoan = "INSERT INTO TAIKHOAN VALUES('phong','123','nguyen phong')";
        db.execSQL(tb_taikhoan);


        db.execSQL(dataSQL.INSERT_DANG_NHAP);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS TaiKhoan");
            onCreate(db);
        }

        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS DangNhap");
            onCreate(db);
        }
    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
