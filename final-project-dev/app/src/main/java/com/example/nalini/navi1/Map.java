package com.example.nalini.navi1;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Map extends AppCompatActivity implements OnMapReadyCallback{

    GoogleMap googleMap;
    boolean mapReady=false;

    MarkerOptions palasia;
    MarkerOptions Bhawrkua;
    MarkerOptions Navlakha;
    MarkerOptions Airport;
    MarkerOptions Vijaynagar;

    static final CameraPosition Indore=CameraPosition.builder().
            bearing(0).target((new LatLng(22.7196,75.8577))).
            tilt(45).zoom(10).build();

    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        palasia=new MarkerOptions().position(new LatLng(22.7270, 75.8810)).title("Apollo Square,Neha");

        Bhawrkua=new MarkerOptions().position(new LatLng( 22.7564132,75.88389440000003)).title("SCSIT,Neha");

        Navlakha =new MarkerOptions().position(new LatLng(22.7045, 75.8737)).title(" Reliance freash,Nidhi");

        Airport=new MarkerOptions().position(new LatLng( 22.7284106,75.8015335)).title(" Airport ,Nidhi");

        Vijaynagar=new MarkerOptions().position(new LatLng(22.7684, 75.8957)).title(" C21 Mall , Priya");

        palasia=new MarkerOptions().position(new LatLng(22.7270, 75.8810)).title(" Near 56 dukan,Priya");



        MapFragment mapFragment=(MapFragment)getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap map) {

        mapReady=true;
        googleMap=map;
        googleMap.addMarker(palasia);
        googleMap.addMarker(Bhawrkua);
        googleMap.addMarker(Navlakha);
        googleMap.addMarker(Airport);
        googleMap.addMarker(Vijaynagar);

        flyTo(Indore);


    }

    private void flyTo(CameraPosition target)
    {
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}