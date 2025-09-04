public class timeClaculator{
public static void main (String[] args){

 
long totalMililSecondNow = System.currentTimeMillis();
 long totalCurrentSecondNow = totalMililSecondNow / 1000;

long time = 1;

long previous = 0;

while ( time < 5){


long totalMililSec = System.currentTimeMillis();
long totalCurrentSecond = totalMililSec / 1000;
long currentSec = totalCurrentSecond % 60;
//time = totalCurrentSecond - totalCurrentSecondNow;
long totalminutes = totalCurrentSecond / 60;
long currentMinutes = totalminutes % 60; 

if(currentMinutes != previous){
System.out.print(currentMinutes+" ");

previous = currentMinutes;


}


}



}




}


































//long totalMililSec = System.currentTimeMillis();
//long totalCurrentSecond = totalMililSec / 1000;
//long currentSec = totalCurrentSecond % 60;
//long totalMin = totalCurrentSecond / 60;
//long currentMin = totalMin % 60;  