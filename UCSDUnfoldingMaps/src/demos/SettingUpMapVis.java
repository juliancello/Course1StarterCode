package demos;

import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.MapUtils;
import module1.HelloWorld;
import processing.core.PApplet;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;

import java.util.ArrayList;
import java.util.List;

public class SettingUpMapVis extends PApplet {

    private UnfoldingMap map;

    public void setup(){
        size(950, 600);
        map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
        map.zoomToLevel(1);
        MapUtils.createDefaultEventDispatcher(this, map);
        Location valLoc = new Location(-38.14f, -73.03f);
//        map.zoomAndPanTo(8, valLoc); // UCSD

        PointFeature valEq = new PointFeature(valLoc);
        valEq.addProperty("title", "Valdivia, Chile");
        valEq.addProperty("magnitude", "9.5");
        valEq.addProperty("date", "May 22, 1960");
        valEq.addProperty("year", 1960);
        Marker valMk = new SimplePointMarker(valLoc, valEq.getProperties());
        map.addMarker(valMk);

        Location alLoc = new Location(61.02f, -147.65f);
        PointFeature alaskaEq = new PointFeature(alLoc);
        alaskaEq.addProperty("title", "Great Alaska Earthquake");
        alaskaEq.addProperty("magnitude", "9.2");
        alaskaEq.addProperty("date", "March 28th, 1964");
        alaskaEq.addProperty("year", 1964);
        Marker alMk = new SimplePointMarker(alLoc, alaskaEq.getProperties());
        map.addMarker(alMk);

        Location sumLoc = new Location(3.30f, 95.78f);
        PointFeature sumatraEq = new PointFeature(sumLoc);
        sumatraEq.addProperty("title", "Off the West Coast of Northern Sumatra");
        sumatraEq.addProperty("magnitude", "9.1");
        sumatraEq.addProperty("date", "December 26th, 2004");
        sumatraEq.addProperty("year", 2004);
        Marker sumMk = new SimplePointMarker(sumLoc, sumatraEq.getProperties());
        map.addMarker(sumMk);

        Location japanLoc = new Location(38.322f, 142.369f);
        PointFeature japanEq = new PointFeature(japanLoc);
        japanEq.addProperty("title", "Near the East Coast of Honashu, Japan");
        japanEq.addProperty("magnitude", "9.0");
        japanEq.addProperty("date", "March 11th, 2011");
        japanEq.addProperty("year", 2011);
        Marker japanMk = new SimplePointMarker(japanLoc, japanEq.getProperties());
        map.addMarker(japanMk);

        Location kamchatkaLoc = new Location(52.76f, 160.06f);
        PointFeature kamchatkaEq = new PointFeature(kamchatkaLoc);
        kamchatkaEq.addProperty("title", "Kamchatka");
        kamchatkaEq.addProperty("magnitude", "9.0");
        kamchatkaEq.addProperty("date", "November 4th, 1952");
        kamchatkaEq.addProperty("year", 1952);
        Marker kamchatkaMk = new SimplePointMarker(kamchatkaLoc, kamchatkaEq.getProperties());
        map.addMarker(kamchatkaMk);

        List<PointFeature> bigEarthquakes = new ArrayList<PointFeature>();
        bigEarthquakes.add(valEq);
        bigEarthquakes.add(alaskaEq);
        bigEarthquakes.add(sumatraEq);
        bigEarthquakes.add(japanEq);
        bigEarthquakes.add(kamchatkaEq);

        List<Marker> markers = new ArrayList<Marker>();
        for (PointFeature eq: bigEarthquakes) {
            markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
        }
        int yellow = color(255, 255, 0);
        int gray = color(150,150,150);

        for (Marker mk :markers) {
            if ( (int) mk.getProperty("year") > 2000 ) {
                mk.setColor(yellow);
            }
            else {
                mk.setColor(gray);
            }
        }

        map.addMarkers(markers);

    }

    public void draw(){
        background(10);
        map.draw();
        addKey(); // ?
    }

    private void addKey()
    {
        // Remember you can use Processing's graphics methods here

    }
    public static void main (String... args) {
        SettingUpMapVis pt = new SettingUpMapVis();
        PApplet.runSketch(new String[]{"SettingUpMapVis"}, pt);
    }
}
