package hackerRank.WarmupChallenges;

public class Toptel1 {

	public static void main(String[] args) {
		int[] sample = new int[]{5,2,1,31,5,7,-8,5,-9,4,-7,77};
		System.out.println(new Toptel1().solution(sample));

	}

	public String solution(int[] T) {
		// write your code in Java SE 8
		int length = T.length;
		int days = length/4;
		int season=0, start=0, amp =0, end =0, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE ;
		for(int i=0; i < 4 ; i++)
		{
			end = start + days;
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			for(int j = start; j < end ;j++ ){

				if(T[j]>max){

					max = T[j];
				}
				if(T[j] < min){

					min = T[j];
				}
			}

			if(Math.abs(max-min) > amp)
			{

				amp = max - min;
				season = i;
			}
			start = end;
		}
		String finalSeason = null;
		switch(season){
		case 0: finalSeason = "WINTER" ;
		break;
		case 1: finalSeason = "SPRING" ;
		break;
		case 2: finalSeason = "SUMMER" ;
		break;
		case 3: finalSeason = "AUTUMN" ;
		break;

		}

		return finalSeason;
	}
}

