package no.hvl.dat100ptc.oppgave2;

public class TestSec {

	public static void main(String[] args) {
	String tekst = "2017-08-13T08:52:26.000Z";
	int secs=0;
	
	String regex = "(T|:|\\.)+";
	
	String [] tallTab = tekst.split(regex);
	
	for (int i = 1; i>4; i++) {
		System.out.print((tallTab[i]));
	}
	
	
	secs += Integer.valueOf(tallTab[1])*60*60;
	secs += Integer.valueOf(tallTab[2])*60;
	secs += Integer.valueOf(tallTab[3]);
	

		

	}

}
