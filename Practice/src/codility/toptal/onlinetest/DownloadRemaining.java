package codility.toptal.onlinetest;

public class DownloadRemaining {
	public static int solution(int x,int[] B,int z) {
		try{
			int length = B.length;
			if(z>=length){
				z=length;
			}
			int lastStartingIndex=length-z;
			int total=0;
			int averageSum=0;
			for(int i=0;i<length;i++){
				total += B[i];
				if(lastStartingIndex==i){
					averageSum += B[i];
					lastStartingIndex++;

				}
			}
			if(total == x) {
				return 0;
			}
			double average=averageSum/2.0;
			return (int)Math.ceil((x-total)/average);
		}
		catch(Exception e)
		{
			return -1;
		}
	}    
}
