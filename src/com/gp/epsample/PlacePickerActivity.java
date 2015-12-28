package com.gp.epsample;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.gp.controller.Utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class PlacePickerActivity extends AppCompatActivity implements OnMapReadyCallback {
	private SupportMapFragment mMapView;
    private GoogleMap mMap;
    private static final int PLACE_PICKER_REQUEST = 1;
    private TextView mName;
    private TextView mAddress;
    private TextView mAttributions;
    private static final LatLngBounds BOUNDS_MOUNTAIN_VIEW = new LatLngBounds(
            new LatLng(37.398160, -122.180831), new LatLng(37.430610, -121.972090));
 
    Button btn_autosearch;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_place);
        
        mMapView =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mMapView.getMapAsync(this);
        mMapView.onCreate(savedInstanceState);
       
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
				getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

				autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
				    @Override
				    public void onPlaceSelected(Place place) {
				        // TODO: Get info about the selected place.
				        Log.i("place", "Place: " + place.getName()+place.getLatLng());
				      
	                    mMap.addMarker(new MarkerOptions()
	                            .position(place.getLatLng())
	                            .title(""+place.getName()));
	                  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(), 15));
				    }

				    @Override
				    public void onError(Status status) {
				        // TODO: Handle the error.
				        Log.i("status", "An error occurred: " + status);
				    }
				  });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch (item.getItemId()) {
		case R.id.action_theme_ligth:
			Utils.changeToTheme(PlacePickerActivity.this,0);
			return true;
		case R.id.action_theme_dark:
			Utils.changeToTheme(PlacePickerActivity.this,1);
			return true;
		case R.id.action_theme_custom:
			Utils.changeToTheme(PlacePickerActivity.this,0);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	// TODO Auto-generated method stub
    	getMenuInflater().inflate(R.menu.main, menu);
		return true;
    }
    
    @Override
    protected void onResume() {
            super.onResume();
            if (mMapView!=null)
            mMapView.onResume();

            }

    @Override
    protected void onPause() {
            if (mMapView!=null)
            mMapView.onPause();
            super.onPause();
            }
    @Override
    protected void onDestroy() {
            super.onDestroy();


            }
    @Override
    public void onLowMemory() {
            super.onLowMemory();
            if (mMapView!=null)
            mMapView.onLowMemory();
            }

            @Override
            public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;

                    // We will provide our own zoom controls.
                    mMap.getUiSettings().setZoomControlsEnabled(false);
                   double lat = Double.valueOf(19.090176500000002);
                    double longg = Double.valueOf(72.8687391);
                    mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(lat, longg))
                            .title("Chhatrapati Shivaji International Airport,Mumbai"));
                  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,longg), 15));

            }
            
            
            
            
    }

