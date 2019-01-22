package com.example.android.brasiliatour;


/**
 * {@link Local} represents a a local, place or touristic sight.
 */
public class Local {
    /**
     * Local Name
     */
    private String mLocalName;

    /**
     * Local Description string resource id
     */
    private int mLocalDescription;

    /**
     * Map location
     */
    private String mMapUri;

    /**
     * Local Phone Number
     */
    private String mPhoneNumber;

    /**
     * Local Website
     */
    private String mWebsite;

    /**
     * Image resource ID for the Local
     */
    private int mImageResourceId;

    /**
     * Create a new Local object.
     *
     * @param localName is the local name
     * @param localDescription is the description of the local
     * @param mapUri is the location of the place in latitude and longitude
     * @param phoneNumber is the contact number of the place
     * @param website is the website of the local
     * @param imageResourceId is the image resource ID of the local
     */
    public Local(String localName, int localDescription, String mapUri, String phoneNumber, String website, int imageResourceId) {
        mLocalName = localName;
        mLocalDescription = localDescription;
        mMapUri = mapUri;
        mPhoneNumber = phoneNumber;
        mWebsite = website;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the local name.
     */
    public String getLocalName(){return mLocalName;}

    /**
     * Get the local description.
     */
    public int getLocalDescription(){return mLocalDescription;}

    /**
     * Get the local map location.
     */
    public String getMapUri(){return mMapUri;}

    /**
     * Get the local phone number.
     */
    public String getPhoneNumber(){return mPhoneNumber;}

    /**
     * Get the local website.
     */
    public String getWebsite(){return mWebsite;}

    /**
     * Get the local image resource ID.
     */
    public int getImageResourceId(){return mImageResourceId;}

}
