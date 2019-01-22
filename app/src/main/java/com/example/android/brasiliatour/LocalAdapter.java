package com.example.android.brasiliatour;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocalAdapter extends ArrayAdapter<Local> {

    /**
     * Resource ID for the background color for this list of locals
     */
    private int mColorResourceId;

    public LocalAdapter(Activity context, ArrayList<Local> locals, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super( context, 0, locals );
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate(
                    R.layout.list_item, parent, false );
        }
        Local currentLocal = getItem( position );

        // Find the TextView in the list_item.xml layout with the ID local_name_text_view
        TextView localNameTextView = (TextView) listItemView.findViewById( R.id.local_name_text_view);
        // Get the Local name from the current Local object and set this text
        localNameTextView.setText(currentLocal.getLocalName());

        // Find the TextView in the list_item.xml layout with the ID description_text_view
        TextView descriptionTextView = (TextView) listItemView.findViewById( R.id.description_text_view);
        // Get the Local description from the current Local object and set this text
        descriptionTextView.setText(currentLocal.getLocalDescription());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById( R.id.image );
        // Set the image Resource from the currentLocal in this ImageView.
        imageView.setBackgroundColor(imageView.getResources().getColor( R.color.background_color ));
        imageView.setImageResource( currentLocal.getImageResourceId() );

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById( R.id.text_container );
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor( getContext(), mColorResourceId );
        // Set the background color of the text container View
        textContainer.setBackgroundColor( color );

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
