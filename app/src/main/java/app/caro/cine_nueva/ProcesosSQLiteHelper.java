package app.caro.cine_nueva;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProcesosSQLiteHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "consultaHorariosDB.sqlite";

    public ProcesosSQLiteHelper(Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DataBaseManager.crearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Por facilidad, descarto la tabla vieja y pongo la nueva
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DataBaseManager.TABLE_NAME);
        sqLiteDatabase.execSQL(DataBaseManager.crearTabla);
    }


}
