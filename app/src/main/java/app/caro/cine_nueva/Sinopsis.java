package app.caro.cine_nueva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


public class Sinopsis extends android.support.v4.app.Fragment {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.sinopsis_fragment, container, false);

        sp = getActivity().getSharedPreferences("Opciones_Guardadas", Context.MODE_PRIVATE); // para tener una pref para toda la app
        editor=sp.edit();

        TextView tv = (TextView) rootView.findViewById(R.id.titulo_pelicula1);
        TextView form = (TextView) rootView.findViewById(R.id.formato1);
        ImageView imag = (ImageView) rootView.findViewById(R.id.icono1);
        TextView dur = (TextView) rootView.findViewById(R.id.duracion1);
        RatingBar RB = (RatingBar) rootView.findViewById(R.id.ratingBar3);
        TextView sinopsis = (TextView) rootView.findViewById(R.id.sinopsis);
        TextView enlace = (TextView) rootView.findViewById(R.id.trailer_link);

        tv.setText(sp.getString("Movie", ""));
        form.setText(sp.getString("Form", ""));
        dur.setText(sp.getString("Duracion", ""));
        sinopsis.setText(sp.getString("Sinopsis", ""));
        imag.setImageResource(sp.getInt("Image", 0));

        RB.setRating(sp.getFloat("Puntos",0));


        enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sp.getString("Enlaces",""))));

            }
        });


        return rootView;

    }
}

