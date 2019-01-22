package com.example.android.brasiliatour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.net.Uri;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttractionsFragment extends Fragment {


    public AttractionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.locals_list, container, false );

        // Creating our ArrayList of Local objects
        final ArrayList<Local> locals = new ArrayList<Local>(  );

        // Defining the Locals objects and ArrayList<Local>
        locals.add( new Local("Parque Nacional",R.string.parque_nacional_description, "Sman Parque Nacional de Brasília - Zona Industrial, Brasília - DF" ,"(61) 3233-4553", "https://pt.wikipedia.org/wiki/Parque_Nacional_de_Brasília" ,R.drawable.parque_nacional_brasilia));
        locals.add( new Local("Catedral de Brasília",R.string.catedral_description , "Esplanada dos Ministérios Catedral Metropolitana Nossa Senhora Aparecida - Brasília, DF"  ,"(61) 3224-4073" , "http://catedral.org.br" , R.drawable.catedral));
        locals.add( new Local("Torre de TV",R.string.torre_de_tv_description, "Torre de TV de Brasília - Eixo Monumental - Jardim Burle Marx, Brasília - DF" ,"(61) 3226-0153", "http://www.turismo.df.gov.br/torre-de-tv/" ,R.drawable.torre_de_tv_brasilia));
        locals.add( new Local("Santuário Dom Bosco",R.string.santuario_dom_bosco_description, "SGAS I Setor de Habitações Individuais Geminadas Sul 702 Santuário Dom Bosco - Asa Sul, Brasília - DF" ,"(61) 3223-6542", "http://arquidiocesedebrasilia.org.br" ,R.drawable.santuario_dom_bosco));
        locals.add( new Local("Parque da Cidade",R.string.parque_da_cidade_description, "Srps Parque da Cidade Sarah Kubitschek - Brasília, DF" ,"(61) 3329-0400", "https://pt.wikipedia.org/wiki/Parque_da_Cidade_Dona_Sarah_Kubitschek" ,R.drawable.parque_da_cidade_brasilia));
        locals.add( new Local("Memorial JK",R.string.memorial_jk_description, "Zona Cívico-Administrativa Memorial JK, Praça do Cruzeiro - Lado Oeste, Brasília - DF" ,"(61) 3225-9451", "http://www.memorialjk.com.br",R.drawable.memorial_jk));
        locals.add( new Local("Museu Nacional",R.string.museu_nacional_description, "Setor Cultural Sul Museu Nacional - Esplanada dos Ministérios, Brasília - DF" ,"(61) 3325-5220", "http://www.cultura.df.gov.br/museu-nacional/" ,R.drawable.museu_nacional_brasilia));
        locals.add( new Local("Templo da Boa Vontade",R.string.templo_boa_vontade_description, "SGAS I Templo da Boa Vontade - Brasília, DF" ,"(61) 3114-1070", "https://www.tbv.com.br" ,R.drawable.templo_da_boa_vontade));
        locals.add( new Local("Parque Olhos D\'Água",R.string.parque_olhos_dagua_description, "SQN Quadra 413 e 414 Parque Olhos D'Água - Asa Norte, Brasília - DF" ,"(61) 3447-3167", "http://mapas.cultura.gov.br/espaco/9456/" ,R.drawable.parque_olhos_dagua));
        locals.add( new Local("CCBB",R.string.ccbb_description, "Setor de Clubes Esportivos Sul Trecho 2 CCBB - Centro Cultural Banco do Brasil - Asa Sul, Brasília - DF" ,"(61) 3108-7600", "http://culturabancodobrasil.com.br/portal/distrito-federal/" ,R.drawable.ccbb_brasilia));

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
