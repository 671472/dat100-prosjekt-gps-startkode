package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;

		min = da[0];
		
		for (double d: da) {
			if (d < min){
				min = d;
			}
		}
		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double [] latitudes = new double [gpspoints.length];
		for (int i= 0; i<latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double [] longitudes = new double [gpspoints.length];
		for (int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();
		
		latitude1 = toRadians(latitude1);
		latitude2 = toRadians(latitude2);
		longitude1 = toRadians(longitude1);
		longitude2 = toRadians (longitude2);
		
		double latitude3 = latitude1 - latitude2;
		double longitude3 = longitude1 - longitude2;
		double a = pow((Math.sin(latitude3/2)), 2) + cos(latitude1) * cos(latitude2) * pow(Math.sin(longitude3/2) , 2);
		
		double c = 2 * atan2(sqrt(a), sqrt(1-a));
		
		 d = R * c;
		 
		 return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;

		secs = gpspoint2.getTime() - gpspoint1.getTime();
		double dist = distance(gpspoint1, gpspoint2);
		
		speed = (dist/secs)*3.6;
		return speed;

		

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = "  %02d:%02d:%02d";

		int hh = secs/3600;
		int mm = (secs / 60) % 60;
		int ss = secs%60;
		
		timestr = String.format(TIMESEP, hh,mm,ss);
		return timestr;
		

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		String TIMESEP = "%10.02f";

		str = String.format(TIMESEP, d);
		
		return str;
		
	}
}
