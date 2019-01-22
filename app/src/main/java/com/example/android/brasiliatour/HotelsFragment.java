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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate( R.layout.locals_list, container, false );

        // Creating our ArrayList of Local objects
        final ArrayList<Local> locals = new ArrayList<Local>(  );

        // Defining the Locals objects and ArrayList<Local>
        locals.add( new Local("B Hotel Brasília",R.string.b_hotel_description, "B Hotel Brasília - Asa Norte, Brasília - DF" ,"(61) 3962-2000", "https://bhotelbrasilia.com.br" ,R.drawable.b_hotel_brasilia));
        locals.add( new Local("Royal Tulip Brasília Alvorada",R.string.royal_tulip_description, "SHTN Trecho 1 Royal Tulip Brasília Alvorada - Asa Norte, Brasília - DF" ,"(61) 3424-7000", "royaltulipbrasiliaalvorada.com" ,R.drawable.royal_tulip));
        locals.add( new Local("Condomínio Life Resort",R.string.life_resort_description, "SHTN Condomínio Life Resort - Brasília, DF" ,"(61) 3252-1225", "http://www.liferesort.com.br" ,R.drawable.life_resort));
        locals.add( new Local("Meliá Brasil 21",R.string.melia_21_description, "Setor Hoteleiro Sul Quadra 6 Meliá Brasil 21 - Asa Sul, Brasília - DF" ,"(61) 3218-4700", "melia.com" ,R.drawable.melia_21));
        locals.add( new Local("Golden Tulip Brasília Alvorada",R.string.golden_tulip_description, "SHTN Trecho 01 Conjunto 1B Golden Tulip Brasília Alvorada - Asa Norte, Brasília - DF" ,"(61) 3429-8000", "https://www.obomdeviajar.com.br/hotel-em-brasilia/golden-tulip-brasilia-alvorada/" ,R.drawable.golden_tulip));
        locals.add( new Local("Cullinan Hplus Premium",R.string.cullinan_description, "SHN Quadra 4 Cullinan Hplus Premium - Asa Norte, Brasília - DF" ,"(61) 3426-5000", "https://www.hplus.com.br/hotel/cullinan-hplus-premium/" ,R.drawable.cullinan_hotel));
        locals.add( new Local("Windsor Plaza Brasília Hotel",R.string.windsor_description, "Setor Hoteleiro Sul Quadra 5 Bloco H Windsor Plaza Brasília Hotel - Asa Sul, Brasília - DF" ,"(61) 2195-1100", "https://windsorhoteis.temp.w3br.com/hotel/windsor-plaza-brasilia/" ,R.drawable.windsor_plaza));
        locals.add( new Local("Brasília Palace Hotel",R.string.brasilia_palace_description, "Asa Norte Trecho 1 Brasilia Palace Hotel - Brasília, DF" ,"(61) 3306-9000", "https://www.brasiliapalace.com.br" ,R.drawable.brasilia_palace_hotel));
        locals.add( new Local("Villa Triacca Eco Pousada",R.string.villa_triacca_description, "Villa Triacca Eco Pousada - Paranoá, Brasília - DF" ,"(61) 98463-1939", "http://www.villatriacca.com.br" ,R.drawable.villa_triacca));

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
