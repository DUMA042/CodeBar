package com.example.codebar;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    final static String Product_detail_URL =
            "https://api.barcodelookup.com/v2/products?";

    final static String PARAM_QUERY = "barcode";

    /*
     * The sort field. One of stars, forks, or updated.
     * Default: results are sorted by best match if no field is specified.
     */
    final static String PARAM_Formatted = "formatted";
    final static String PARAM_Key = "key";
    final static String type_formatted= "y";
    final static String type_key="8d897584sx0vf79xpnwqi3kx5lqlkf";
//https://api.barcodelookup.com/v2/products?barcode=5449000000996&formatted=y&key=8d897584sx0vf79xpnwqi3kx5lqlkf
    /**
     * Builds the URL used to query GitHub.
     *
     * @param githubSearchQuery The keyword that will be queried for.
     * @return The URL to use to query the GitHub server.
     */
    public static URL buildUrl(String githubSearchQuery) {
        // TODO (1) Fill in this method to build the proper GitHub query URL
        Uri builtUri=Uri.parse(Product_detail_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY,githubSearchQuery)
                .appendQueryParameter(PARAM_Formatted,type_formatted)
                .appendQueryParameter(PARAM_Key,type_key)
                .build();
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;


    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}