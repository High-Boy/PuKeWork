package minjiework1;
import java.util.*;
public class PuKe {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int m = 0,n=0;
        System.out.println("������Black��Ӧ�����ƣ�");
        Scanner scanner=new Scanner(System.in);
        System.out.println("������White��Ӧ�����ƣ�");
        Scanner shuru=new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        while (scanner.hasNextLine()) {			
        	String string = scanner.nextLine();			
			list.add(string);			
        	if (list.size() == 5) {				
        		m= getCard(list);											
        		}
        }
        while (shuru.hasNextLine()) {			
        	String string = shuru.nextLine();			
			list.add(string);			
        	if (list.size() == 5) {				
        		n = getCard(list);											
        		}
        }
        if(m<n) {
        	System.out.println("Black wins!");
        }
        else if(m==n) {
        	System.out.println("Tie.");
        }
        else {
        	System.out.println("White wins!");
        }
        scanner.close();
        shuru.close();
	}
	private static int getCard(List<String> list) {		
		int temp = 7;		
		int size = list.size();		
		List<String> numList = new ArrayList<String>();		
		Set<String> numSet = new TreeSet<String>();		
		List<String> colourList = new ArrayList<String>();		
		Set<String> colourSet = new TreeSet<String>();		
		for (int i = 0; i < list.size(); i++) {			
			String num = list.get(i).split(" ")[0];			
			String colour = list.get(i).split(" ")[1];			
			if (num.equals("J")) {				
				numList.add("11");				
				numSet.add("11");			
				} 
			else if (num.equals("Q")) {				
				numList.add("12");				
				numSet.add("12");			
				} 
			else if (num.equals("K")) {				
				numList.add("13");				
				numSet.add("13");			
				} 
			else if (num.equals("A")) {				
				numList.add("14");				
				numSet.add("14");			
				} 
			else {				
				numList.add(num);				
				numSet.add(num);			
				}			
			colourList.add(colour);			
			colourSet.add(colour);		
			}		
		// ͬ��˳,����ͬ��		
		if (colourSet.size() == 1) {			
			Collections.sort(numList);			
			for (int i = 0; i < numList.size() - 1; i++) {				
				if (Integer.parseInt(numList.get(i + 1)) - Integer.parseInt(numList.get(i)) == 1) {					
					if (i == numList.size() - 2) {						
						temp = 1;					
						}					
					continue;				
					}
				else {					
					if (temp > 4) {						
						temp = 2;					
						}				
					}			
				}		
			}		
		// ����		
		if (numSet.size() == 3) {			
			if (temp > 6) {				
				temp = 3;			
				}		
			}		
		// ˳��		
		if (colourSet.size() > 1) {			
			Collections.sort(numList);			
			for (int i = 0; i < numList.size() - 1; i++) {				
				if (Integer.parseInt(numList.get(i + 1)) - Integer.parseInt(numList.get(i)) == 1) {					
					if (i == numList.size() - 2) {						
						if(temp>5){							
							temp = 4;						
							}					
						}				
					} else
					{					
						break;				
						}			
				}		
			}
		//����
		for (int i = 0; i < numList.size() - 1; i++) {
			if(numList.get(i)==numList.get(i+1)) {
				if(temp>4) {
					temp=5;
				}
			}
		}
		//����
		for (int i = 0; i < numList.size() - 1; i++) {
			if(numList.get(i)==numList.get(i+1)) {
				if(temp>3) {
					temp=6;
				}
			}
		}
		//ɢ��
		if(temp>2) {
			temp=7;
		}
		return temp;	
		}	
}
