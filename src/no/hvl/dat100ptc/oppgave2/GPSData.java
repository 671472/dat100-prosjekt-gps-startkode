package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSData {

	private GPSPoint[] gpspoints;
	protected int antall = 0;

	public GPSData(int n) {
		antall = 0;
		gpspoints = new GPSPoint[n];
		
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	protected boolean insertGPS(GPSPoint gpspoint) {
		boolean inserted = false;
		if (antall<gpspoints.length && !inserted) {
			gpspoints[antall] = gpspoint;
			antall++;  // Øker antall med 1 for å sette neste objeket i neste indeks
			inserted = true;  
		}
	return inserted;  // returnerer true får å vise om objektet ble satt inn eller ikke
 
	}

	public boolean insert(String time, String latitude, String longitude, String elevation) {

		GPSPoint gpspoint;

		gpspoint = GPSDataConverter.convert(time, latitude, longitude, elevation);
		
		return insertGPS(gpspoint);
		
	}

	public void print() {

		System.out.println("====== Konvertert GPS Data - START ======");

		for (GPSPoint gpspoint : gpspoints) {  // bruker utvidet for-løkke til å skrive ut 
			System.out.println(gpspoint.toString());
			
		}
		
		 System.out.println("====== Konvertert GPS Data - SLUTT ======");

	}
}
