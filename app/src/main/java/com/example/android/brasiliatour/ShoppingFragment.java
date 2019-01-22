package com.example.android.brasiliatour;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.locals_list, container, false );

        // Creating our ArrayList of Local objects
        final ArrayList<Local> locals = new ArrayList<Local>(  );

        // Defining the Locals objects and ArrayList<Local>
        locals.add( new Local( "Brasilia Shopping", R.string.brasilia_shopping_description, "SCN Q5 Brasília Shopping, BL A - Asa Norte, Brasília - DF" , "(61) 2109-2122" , "http://brasiliashopping.com.br", R.drawable.brasilia_shopping) );
        locals.add( new Local( "Conjunto Nacional", R.string.conjunto_nacional_description, "Conjunto Nacional - Asa Norte, Brasília - DF" , "(61) 2106-9700" , "https://www.conjuntonacional.com.br/", R.drawable.conjunto_nacional) );
        locals.add( new Local( "Pier 21", R.string.conjunto_nacional_description, "Setor de Clubes Esportivos Sul Trecho 2 Pier 21 32 - Asa Sul, Brasília - DF" , "(61) 3251-2121" , "http://www.pier21.com.br/", R.drawable.pier_21) );
        locals.add( new Local( "Patio Brasil", R.string.patio_brasil_description, "Setor Comercial Sul Quadra 07 Pátio Brasil Shopping, Bloco A - Asa Sul, Brasília - DF" , "(61) 2107-7400" , "http://www.patiobrasil.com.br", R.drawable.patio_brasil) );
        locals.add( new Local( "Boulevard Shopping", R.string.boulevard_shopping_description, "STN Boulevard Shopping Brasília - Asa Norte, Brasília - DF" , "0300 313 1061" , "http://www.boulevardbrasilia.com.br", R.drawable.boulevard_brasilia) );
        locals.add( new Local( "Iguatemi Brasília", R.string.iguatemi_shopping_description, "Setor de Habitações Individuais Norte CA 4 Iguatemi Brasilia - Lago Norte, Brasília - DF" , "(61) 3577-5000" , "https://iguatemi.com.br/brasilia/", R.drawable.iguatemi_brasilia) );
        locals.add( new Local( "Terraço Shopping", R.string.terraco_shopping_descriptions, "Octogonal Terraço Shopping 05 - Brasília, DF" , "(61) 3403-2992" , "http://www.terracoshopping.com.br", R.drawable.terraco_shopping) );
        locals.add( new Local( "JK Shopping", R.string.jk_shopping_description, "Setor M Norte QNM 34 JK SHOPPING - Taguatinga, Brasília - DF" , "(61) 3246-8600" , "http://www.jkshoppingdf.com.br", R.drawable.jk_shopping) );
        locals.add( new Local( "Taguatinga Shopping", R.string.taguatinga_shopping_description, "Taguatinga Shopping - Rua 210 Qs 1 Rua 210, Lote 40 - Taguatinga, Brasília - DF" , "(61) 3451-6000" , "http://www.taguatingashopping.com.br", R.drawable.taguatinga_shopping) );
        locals.add( new Local( "Águas Claras Shopping", R.string.aguas_claras_shopping_description, "Águas Claras Shopping - Avenida das Araucárias - Águas Claras, Brasília - DF" , "(61) 3436-1600" , "http://www.aguasclarashopping.com.br", R.drawable.aguas_claras_shopping) );

        // Setting the adapter, the ArrayList and the background color.
        LocalAdapter adapter = new LocalAdapter( getActivity(), locals, R.color.background_color );

        ListView listView = (ListView) rootView.findViewById( R.id.list );

        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent localView = new Intent( getContext(), LocalViewActivity.class );
                localView.putExtra( "local_name",locals.get( position ).getLocalName() );
                localView.putExtra( "local_description",locals.get( position ).getLocalDescription() );
                localView.putExtra( "local_map_uri",locals.get( position ).getMapUri() );
                localView.putExtra( "local_phone_number",locals.get( position ).getPhoneNumber() );
                localView.putExtra( "local_website",locals.get( position ).getWebsite() );
                localView.putExtra( "local_image_id",locals.get( position ).getImageResourceId() );
                startActivity( localView );
            }
        } );

        return rootView;
    }

}
