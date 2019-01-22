package com.example.android.brasiliatour;


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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.locals_list, container, false );

        // Creating our ArrayList of Local objects
        final ArrayList<Local> locals = new ArrayList<Local>(  );

        // Defining the Locals objects and ArrayList<Local>
        locals.add( new Local( "Coco Bambu Lago Sul", R.string.coco_bambu_description ,  "Setor de Clubes Esportivos Sul Trecho 2 Restaurante Coco Bambu Lago Sul, Icone Parque - Asa Sul, Brasília - DF"  , "(61) 3224-5585" ,  "https://restaurante-coco-bambu-lago-sul.business.site" , R.drawable.coco_bambu ) );
        locals.add( new Local( "Villa Tevere", R.string.villa_tevere_description ,  "Asa Sul Comércio Local Sul 115 Bloco A Villa Tevere - Asa Sul, Brasília - DF"  , "(61) 3345-5513" ,  "http://www.villatevere.com.br" , R.drawable.villa_tevere ) );
        locals.add( new Local( "New Koto", R.string.new_koto_description ,  "Asa Sul Comércio Local Sul 212 New Koto - Brasília, DF"  , "(61) 3346-9668" ,  "https://www.facebook.com/pages/New-Koto/203520163004569" , R.drawable.new_koto ) );
        locals.add( new Local( "Bloco C", R.string.bloco_c_description ,  "Asa Sul 211 Bloco C - Brasília, DF"  , "(61) 3363-3062" ,  "https://www.facebook.com/blocoCrestaurante/" , R.drawable.bloco_c_restaurant ) );
        locals.add( new Local( "Santé 13", R.string.sante_13_description ,  "Asa Norte Comércio Local Norte 413 Restaurante Santé 13 - Brasília, DF"  , "(61) 3037-2132" ,  "http://tagme.com.br/menu/sante13/pt" , R.drawable.sante_13 ) );
        locals.add( new Local( "Taypá", R.string.taypa_description ,  "QI 17 Bloco G Taypá - Lago Sul, Brasília - DF"  , "(61) 3248-0403" ,  "https://www.taypa.com.br" , R.drawable.taypa_restaurant ) );
        locals.add( new Local( "Mangai Brasília", R.string.mangai_description ,  "Setor de Clubes Esportivos Sul Trecho 2 Mangai Brasília - Asa Sul, Brasília - DF"  , "(61) 3252-0156" ,  "http://mangai.com.br" , R.drawable.mangai_brasilia ) );
        locals.add( new Local( "Ticiana Werner", R.string.ticiana_werner_description ,  "Asa Sul Comércio Local Sul 201 Ticiana Werner - Asa Sul, Brasília - DF"  , "(61) 3226-9947" ,  "http://www.ticianawerner.com.br" , R.drawable.ticiana_werner ) );
        locals.add( new Local( "Dom Francisco", R.string.dom_francisco_description ,  "Asa Sul Comércio Local Sul 402 Dom Francisco Restaurante - Asa Sul, Brasília - DF"  , "(61) 3363-3079" ,  "http://domfrancisco.com.br" , R.drawable.dom__francisco ) );
        locals.add( new Local( "Toro", R.string.toro_description ,  "Asa Sul Comércio Local Sul 104 Bloco C Toro - Asa Sul, Brasília - DF"  , "(61) 3225-0494" ,  "http://www.toroparrillasul.com.br" , R.drawable.toro_brasilia ) );


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
