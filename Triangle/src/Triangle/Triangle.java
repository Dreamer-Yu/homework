package Triangle;
	
public class Triangle {
	public int isTriangle(int a,int b,int c){
		if(a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a){
			return 1;
		}
		return 0;
	}
	public int equilateral(int a,int b,int c){
		if(isTriangle(a,b,c)==1){
			if(a==b && b==c){
				return 1;//µÈ±ß
			}
		}
		return 0;
	}
	public int isosceles(int a,int b,int c){
		if(isTriangle(a,b,c)==1){
			if(a==b || b==c || a==b){
				return 1;//µÈÑü
			}
		}
		return 0;
	}
	public int scalene(int a,int b,int c){
		if(isTriangle(a,b,c)==1){
			if(a==b || b==c || a==b){
				return 0;//µÈÑü
			}
			return 1;
		}
		return 0;
	}
}
