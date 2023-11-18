package anhntph36936.fpoly.sanpham_du1.MyDBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Helper extends SQLiteOpenHelper {

    static String DB_NAME = "Da1_n8";
    static  int DB_VERSION = 1;

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

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS TaiKhoan");
            onCreate(db);
        }
    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
