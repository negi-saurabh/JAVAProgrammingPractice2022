package codility.toptal.onlinetest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TimeRepresentation {

	public static Map<Integer, String> timeMapping = new HashMap<>();
	public static int weekTime = 7*24*60*60;
	public static int dayTime = 24*60*60;
	public static int hourTime = 60*60;
	public static int minTime = 60;
	public static int secondTime = 1;

	public static String solution(int X) {
		String generatedTime =  generateTime(X);
		
		if(generatedTime.length() > 5) {
			// 2h1m3s
			String sub = generatedTime.substring(0, 2);
			int newval = generatedTime.charAt(2) - '0' + 1;
			char secondUnit = generatedTime.charAt(3);
			generatedTime = sub+newval+secondUnit;
		}
		return generatedTime;
	}



	private static String generateTime(int X) {
		StringBuffer leftOverTime = new StringBuffer();
		
		if(X > weekTime) {
			int times = X / weekTime;
			int reminder = X % weekTime;
			leftOverTime.append(times);
			leftOverTime.append("w");
			String recursedTime = generateTime(reminder);
			leftOverTime.append(recursedTime);
		}
		else if(X < weekTime && X > dayTime ) {
			int times = X / dayTime;
			int reminder = X % dayTime;
			leftOverTime.append(times);
			leftOverTime.append("d");
			String recursedTime = generateTime(reminder);
			leftOverTime.append(recursedTime);
		}
		else if(X < dayTime && X > hourTime ) {
			int times = X / hourTime;
			int reminder = X % hourTime;
			leftOverTime.append(times);
			leftOverTime.append("h");
			String recursedTime = generateTime(reminder);
			leftOverTime.append(recursedTime);
		}
		else if(X < hourTime && X > minTime ) {
			int times = X / minTime;
			int reminder = X % minTime;
			leftOverTime.append(times);
			leftOverTime.append("m");
			String recursedTime = generateTime(reminder);
			leftOverTime.append(recursedTime);
		}
		else {
			leftOverTime.append(X);
			leftOverTime.append("s");
		}
		return leftOverTime.toString();
	}



	public static void main(String[] args) throws IOException {
		System.out.println(solution(86461));
		timeMapping.put(7*24*60*60 , "1w");
		timeMapping.put(24*60*60, "1d");
		timeMapping.put(60*60, "1h");
		timeMapping.put(60, "1m");
		timeMapping.put(1, "1s");
	}

}
