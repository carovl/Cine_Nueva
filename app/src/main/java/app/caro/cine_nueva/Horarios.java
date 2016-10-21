package app.caro.cine_nueva;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Horarios extends Fragment {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.horarios_fragment, container, false);

        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();


        TextView tv = (TextView) rootView.findViewById(R.id.titulo_pelicula2);
        TextView form = (TextView) rootView.findViewById(R.id.formato2);
        ImageView imag = (ImageView) rootView.findViewById(R.id.icono2);
        TextView dur = (TextView) rootView.findViewById(R.id.duracion2);

        tv.setText(sp.getString("Movie", "")); //titulo
        form.setText(sp.getString("Form", "")); //formato
        dur.setText(sp.getString("Duracion", "")); //duracion
        imag.setImageResource(sp.getInt("Image", 0)); //icono


        final CheckBox cb1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
        final CheckBox cb2 = (CheckBox) rootView.findViewById(R.id.checkBox2);
        final CheckBox cb3 = (CheckBox) rootView.findViewById(R.id.checkBox3);
        final CheckBox cb4 = (CheckBox) rootView.findViewById(R.id.checkBox4);

        cb1.setChecked(sp.getBoolean("CB1", false));
        cb2.setChecked(sp.getBoolean("CB2", false));
        cb3.setChecked(sp.getBoolean("CB3", false));
        cb4.setChecked(sp.getBoolean("CB4", false));


        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                sp.edit().putBoolean("CB1", isChecked).commit(); // Guardo el nuevo valor del  CheckBox
                //editor.putString("Hora", "3:00 PM").commit();

            }
        });

        cb2.setChecked(sp.getBoolean("CB2", false));
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sp.edit().putBoolean("CB2", b).commit(); // Guardo el nuevo valor del  CheckBox

            }
        });


        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sp.edit().putBoolean("CB3", b).commit(); // Guardo el nuevo valor del  CheckBox

            }
        });


        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sp.edit().putBoolean("CB4", b).commit(); // Guardo el nuevo valor del  CheckBox

            }
        });



        return rootView;
    }
}