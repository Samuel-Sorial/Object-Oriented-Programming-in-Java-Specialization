package module4;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.PGraphics;

/**
 * Implements a visual marker for cities on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class CityMarker extends SimplePointMarker {

	// The size of the triangle marker
	// It's a good idea to use this variable in your draw method
	public static final int TRI_SIZE = 5;

	public CityMarker(Location location) {
		super(location);
	}

	public CityMarker(Feature city) {
		super(((PointFeature) city).getLocation(), city.getProperties());
	}

	/**
	 * Implementation of method to draw marker on the map.
	 */
	public void draw(PGraphics pg, float x, float y) {
		// Save previous drawing style
		pg.pushStyle();

		pg.fill(150, 30, 30);
		pg.triangle(x, y - TRI_SIZE, x - TRI_SIZE, y + TRI_SIZE, x + TRI_SIZE, y + TRI_SIZE);

		// Restore previous drawing style
		pg.popStyle();
	}

	/*
	 * Local getters for some city properties. You might not need these in module 4.
	 */
	public String getCity() {
		return getStringProperty("name");
	}

	public String getCountry() {
		return getStringProperty("country");
	}

	public float getPopulation() {
		return Float.parseFloat(getStringProperty("population"));
	}
}