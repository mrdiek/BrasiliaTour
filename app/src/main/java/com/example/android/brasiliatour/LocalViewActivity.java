package com.example.android.brasiliatour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class LocalViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.local_view );

        final Intent intent = getIntent();

        // Find the View with the ID container1
        View container1BackgroundColor = (View) findViewById( R.id.container1 );
        // Set this background color to the container1 view
        container1BackgroundColor.setBackgroundColor( getResources().getColor( R.color.background_color ) );

        // Find the TextView in the local_view.xml layout with the ID local_name_text_view
        TextView localName = (TextView) findViewById( R.id.local_name_view);
        // Get the Local name from the current Local object and set this text
        localName.setText( intent.getStringExtra( "local_name") );

        // Find the TextView in the local_view.xml layout with the ID local_description
        TextView localDescription = (TextView) findViewById( R.id.local_description);
        // Get the Local description from the current Local object and set this text
        localDescription.setText( intent.getIntExtra( "local_description", 0) );

        // Find the TextView in the local_view.xml layout with the ID location
        TextView location = (TextView) findViewById( R.id.location);
        // Get the Local map URI from the current Local object and set this text
        final Uri localMapUri = Uri.parse( "http://maps.google.co.in/maps?q=" + intent.getStringExtra( "local_map_uri" ));
        location.setText( intent.getStringExtra( "local_map_uri" ) );
        // Setting Click Listener
        location.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mapIntent = new Intent( Intent.ACTION_VIEW );
                mapIntent.setData( localMapUri );
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity( mapIntent );
            }
        } );

        // Find the TextView in the local_view.xml layout with the ID phone_number
        TextView localPhoneNumber = (TextView) findViewById( R.id.phone_number);
        // Get the Local phone number from the current Local object and set this text
        localPhoneNumber.setText( intent.getStringExtra( "local_phone_number" ) );
        final Uri phoneUri = Uri.parse( intent.getStringExtra( "local_phone_number" ) );
        // Setting Click Listener
        localPhoneNumber.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent( Intent.ACTION_DIAL );
                phoneIntent.setData( phoneUri );
                startActivity( phoneIntent );
            }
        } );

        // Find the TextView in the local_view.xml layout with the ID website
        TextView localWebsite = (TextView) findViewById( R.id.website);
        // Get the Local website from the current Local object and set this text
        final Uri localWebUri = Uri.parse( intent.getStringExtra( "local_website" ));
        localWebsite.setText( intent.getStringExtra( "local_website" ));
        // Setting Click Listener
        localWebsite.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent webIntent = new Intent( Intent.ACTION_VIEW );
                webIntent.setData(localWebUri);
                startActivity( webIntent );
            }
        } );

        // Find the TextView in the local_view.xml layout with the ID image_view
        ImageView localImageResourceId = (ImageView) findViewById( R.id.image_view);
        // Get the Local image resource ID from the current Local object and set this image
        localImageResourceId.setImageResource( intent.getIntExtra( "local_image_id",0 ) );


    }

}
