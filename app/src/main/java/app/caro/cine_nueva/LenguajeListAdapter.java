package app.caro.cine_nueva;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class LenguajeListAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] itemname;
    private final Integer[] integers;
    private final String[] formato;

    public LenguajeListAdapter(Activity context, String[] itemname, Integer[] integers, String[] Form ) {
        super(context, R.layout.fila_lista, itemname);
        this.context=context;
        this.itemname=itemname;
        this.integers=integers;
        this.formato =Form;

    }




    public View getView(int posicion,View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.fila_lista,null,true);


        TextView txtTitle = (TextView) rowView.findViewById(R.id.titulo);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        //imageView.setBackgroundResource(R.drawable.borde); // LINEA PARA AGREGAR BORDE
        TextView format = (TextView) rowView.findViewById(R.id.formato);

        txtTitle.setText(itemname[posicion]);
        imageView.setImageResource(integers[posicion]);
        format.setText(formato[posicion]);




        return rowView;
    }


}