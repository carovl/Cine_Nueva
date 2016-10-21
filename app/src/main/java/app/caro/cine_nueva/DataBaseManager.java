package app.caro.cine_nueva;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.CheckBox;

public class DataBaseManager {

    private Context context;
    private ProcesosSQLiteHelper helper;
    private SQLiteDatabase db;

    public static final String Titulo = "TituloPeli";
    public static final String cb1_value ="falso";
    public static final String TABLE_NAME = "Horarios";
    public static final String CN_Id = "_id";

    public static final String crearTabla = "create table "+TABLE_NAME+" ("+
            CN_Id+" integer primary key autoincrement," +
            Titulo + " text," +
            cb1_value + " text)";

    public DataBaseManager(Context context, int version) {
        this.context = context;
        helper = new ProcesosSQLiteHelper(context, version);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues(String Titulo_Peli, String falso){
        ContentValues valores = new ContentValues();
        valores.put(Titulo, "Titulo_Peli");
        valores.put(cb1_value, "falso");
        return valores;
    }

    public void nuevo(String Titulo_Peli, String falso){
        db.insert(TABLE_NAME, null, generarContentValues(Titulo_Peli,falso));
    }

    public void editByID(String ID, String Titulo_Peli, String falso){
        db.update(TABLE_NAME, generarContentValues(Titulo_Peli,falso), CN_Id+"=?", new String[]{ID});
    }

    public boolean isEmpty(){
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        if ( c.moveToFirst() ) { //Devuelve TRUE en caso de que se haga el movimiento sin errores.
            return false;
        }
        return true;
    }

    public ProcesoInfo getIndexedProceso(int i){
        Cursor c = db.query(TABLE_NAME, new String[]{Titulo, cb1_value, CN_Id}, null, null, null, null, null);
        if( !c.moveToFirst() ){ // Devuelve FALSE en caso de que haya error
            return null;
        }
        c.moveToPosition(i);
        return new ProcesoInfo( c.getString(1), c.getString(0), c.getString(2));
    }

    public boolean removeIndexedProceso(int i){
        Cursor c = db.query(TABLE_NAME, new String[]{CN_Id}, null, null, null, null, null);
        if( !c.moveToFirst() ){ // Devuelve FALSE en caso de que haya error
            return false; // Base de datos vacía
        }
        c.moveToPosition(i);
        db.delete(TABLE_NAME, CN_Id+"=?", new String[]{c.getString(0)});
        return true;
    }

    public int size(){
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        return c.getCount();
    }


    public void eliminar_Id(String id){
        db.delete(TABLE_NAME, CN_Id+"=?", new String[]{id});
    }

    public void modificar_Id(String ID, String Titulo, String cb1_value){
        db.update(TABLE_NAME, generarContentValues(Titulo, cb1_value), CN_Id+"=?", new String[]{ID});
    }




}

