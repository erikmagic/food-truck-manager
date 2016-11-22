package ca.mcgill.ecse321.foodtruckmanagement.controller;

public class DayMap	 {
	public static int getNumberDay(Day day){
		if ( day == Day.MONDAY) return 1;
		else if ( day == Day.TUESDAY ) return 2;
		else if ( day == Day.WEDNESDAY) return 3;
		else if ( day == Day.THURSDAY ) return 4;
		else if ( day == Day.FRIDAY ) return 5;
		else if ( day == Day.SATURDAY) return 6;
		else return 7;	
	}
	
	public static Day getDayFromNumber(int number){
		if ( number == 1) return Day.MONDAY;
		else if ( number == 2) return Day.TUESDAY;
		else if ( number == 3) return Day.WEDNESDAY;
		else if ( number == 4) return Day.THURSDAY;
		else if ( number == 5) return Day.FRIDAY;
		else if ( number == 6) return Day.SATURDAY;
		else return Day.SUNDAY;
	}
}
