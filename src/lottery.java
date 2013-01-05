import java.util.Scanner;

public class lottery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		/* inputs[0] = m
		 * inputs[1] = n
		 * inputs[2] = t
		 * inputs[3] = p
		 */
		int inputs[] = new int[4];
		int numNeeded, min;
		double probSum = 0.0;
		double probability, people;	
		
		String input = in.nextLine();
		
		String split[] = input.split(" ");
		for(int a = 0; a<split.length; a++)
			inputs[a] = Integer.parseInt(split[a]);
		
		people = (double) inputs[3]/ (double) inputs[2];
		numNeeded = (int) Math.ceil(people);
		
		System.out.println("Num needed: " + numNeeded);	
		if(numNeeded>inputs[1]) {
			probability = 0.0;
			System.out.println(probability);
			return;
		}

		min = Math.min(inputs[3],inputs[1]);
		System.out.println("Min: "+min);
		while(min>=numNeeded)
		{
			probSum += choose(inputs[3], min)*choose(inputs[0]-inputs[3], inputs[1]-min);
			min--;
		}
		probability = probSum/choose(inputs[0],inputs[1]);
		System.out.println("Probability: " + probability);

		return;
	}
	
	static double choose(int A, int B)
	{
		if(B<0 || B>A) return 0;
		double temp = 1.0;
		int max = Math.max(A-B, B);
		int min = Math.min(A-B, B);
		while(A>max)
			temp*=A--;
		while(min>0)
			temp/=min--;
		return temp;
	}

}
