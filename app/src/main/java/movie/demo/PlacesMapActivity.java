package movie.demo;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class PlacesMapActivity extends Activity {
	// Nearest places
	PlacesList nearPlaces;
	
	// Map 
	GoogleMap map;
	
	double latitude;
	double longitude;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_places);

		// Getting intent data
		Intent i = getIntent();
		
		// Users current geo location
		String user_latitude = i.getStringExtra("user_latitude");
		String user_longitude = i.getStringExtra("user_longitude");
		
		// Nearplaces list
		nearPlaces = (PlacesList) i.getSerializableExtra("near_places");
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		//mapView = ((MapView) findViewById(R.id.mapView)).getMap();
		
		map.setMyLocationEnabled(true);
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		LatLng latLng = new LatLng((int)(Double.parseDouble(user_latitude) * 1E6),(int) (Double.parseDouble(user_longitude) * 1E6));
	    
	    map.addMarker(new MarkerOptions()
	            .position(latLng)
	            .title("My Spot")
	            .snippet("This is my spot!")
	            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).visible(true));
	       
	    
	    final LatLng pos = new LatLng((int)(Double.parseDouble(user_latitude) * 1E6),(int) (Double.parseDouble(user_longitude) * 1E6));
	    map.setOnCameraChangeListener(new OnCameraChangeListener() {
	    		public void onCameraChange(CameraPosition arg0) {
	    			//map.animateCamera(CameraUpdateFactory.newLatLngZoom(pos, 13));
	    		}
	        });

	    
//	    map.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
//			
//			@Override
//			public void onInfoWindowClick(Marker arg0) {
//				Intent intent = new Intent(getBaseContext(), PlaceDetails.class);
//				String reference =.get(arg0.getId());
//				intent.putExtra("reference", reference);
//				
//				// Starting the Place Details Activity
//				startActivity(intent);
//			}
//
//		});
        
        
  
	    
		// check for null in case it is null
		if (nearPlaces.results != null) {
			// loop through all the places
			for (Place place : nearPlaces.results) {
				latitude = place.geometry.location.lat; // latitude
				longitude = place.geometry.location.lng; // longitude
				LatLng latlong = new LatLng(latitude, longitude);
				MarkerOptions markerOptions=new MarkerOptions();
                // Setting the position for the marker
                markerOptions.position(latlong);
                markerOptions.icon(null);
                markerOptions.visible(true);
                // Setting the title for the marker.
                //This will be displayed on taping the marker
               markerOptions.title(place.name + " : " + place.vicinity);
 
                // Placing a marker on the touched position
                map.addMarker(markerOptions);
			}
		}


	}


}
