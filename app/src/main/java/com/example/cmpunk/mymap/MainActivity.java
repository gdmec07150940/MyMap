package com.example.cmpunk.mymap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextOptions;
import com.baidu.mapapi.model.LatLng;

import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

public class MainActivity{
    private MapView mapView;
    private BaiduMap baiduMap;
    private Marker markerA;
    private InfoWindow infoWindow;
    private PoiSearch mPoiSearch;
    private LatLng dajidian =new LatLng(23.3906,113.4535);



    private void setCenter(LatLng latLng){
        MapStatus mapStatus=new MapStatus.Builder().target(latLng).zoom(18).build();
        MapStatusUpdate mapStatusUpdate= MapStatusUpdateFactory.newMapStatus(mapStatus);
        baiduMap.setMapStatus(mapStatusUpdate);

    }
    private  void setOverlay(){
        BitmapDescriptor bitmapDescriptor=BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
        OverlayOptions overlayOptions=new MarkerOptions().position(dajidian).icon(bitmapDescriptor);
        markerA=(Marker) baiduMap.addOverlay(overlayOptions);



    }
    private void setMapText(){
        OverlayOptions overlayOptions=new TextOptions().text("大机电").fontColor(0xFFFF00FF).fontSize(24).bgColor(0xAAFFFF00).position(dajidian).rotate(45);
        baiduMap.addOverlay(overlayOptions);


    }
    private void POISearch(){
        mPoiSearch.searchNearby(new PoiNearbySearchOption().location(dajidian).keyword("餐厅").radius(1000).pageNum(1));
        mPoiSearch.searchNearby(new PoiNearbySearchOption().location(dajidian).keyword("餐厅").radius(1000).pageNum(1));



    }

    private final LocationListener locationListener=new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            setCenter(new LatLng(location.getLatitude(),location.getLongitude()));
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };
}
