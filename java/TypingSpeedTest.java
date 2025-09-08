import java.util.*;
public class TypingSpeedTest{
static Scanner scanner = new Scanner(System.in);
public static void main(String[] args){

mainMenu();
}
public static void mainMenu(){

String menu = """

Hello dear today i want to Test 

How fast you can actually type a 

Sentence 

ARE YOU READY ???..(yes/no)

""";
System.out.println(menu);
String option = scanner.nextLine();
String lower = option.toLowerCase();

if (lower.equals("yes")){
TypedWords();
}else
if (lower.equals("no")){
System.out.println("Okey my bad!:(\nMaybe you can come over some other days...");
}else{
System.out.println("Invalid input");
}
}

public static String result(String[] typedWords, String [] originalList){

int correctWords = 0;

for (int count = 0; count < originalList.length; count++){
if (typedWords[count].equals(originalList[count])){
correctWords++;

}
}
float wordsLength = (float)(originalList.length);
float totalPercentage = (correctWords / wordsLength * 100);
return "Accuracy percentage is "+String.format("%.2f",totalPercentage)+"%";
}





public static void TypedWords(){
long totalMiliSeconds = System.currentTimeMillis();
long startSecond = totalMiliSeconds / 1000;
long startmin = startSecond / 60;

String sentence = """
Learning to code in java is exciting it allows
you to solve problems, and create useful applications for everyday
life while improving logical thinking skills step by step.""";
System.out.println(sentence);
String typeSentence = scanner.nextLine();

String [] typedWords = typeSentence.split(" ");

long totalMiliSec = System.currentTimeMillis();
long endSecond = totalMiliSec / 1000;
long endmin = endSecond / 60;

long totalseconds = endSecond - startSecond;
int  totalMin = (int)(endmin - startmin); 

int wordsPerminutes = minutesDivision(typedWords.length, totalMin); 
System.out.println("Total Time taken in seconds is "+totalseconds);
System.out.println("Words per minutes Approximatly "+ wordsPerminutes);

if (typedWords.length > addTestToList().length){
String [] biggerList = biggerLength(typedWords);
String [] stripedList = strpBiggerLength(typedWords);
System.out.println(result(stripedList,biggerList)); 
}else{
String [] filledUp = fillUp(typedWords);
System.out.println(result(filledUp, addTestToList()));


}
}




public static String[] addTestToList(){

String sentence = """
Learning to code in java is exciting it allows
you to solve problems, and create useful applications for everyday
life while improving logical thinking skills step by step.""";




String [] Originalwords = sentence.split(" ");

for (int count = 0; count < Originalwords.length; count++){
Originalwords[count] = Originalwords[count].strip(); 

}



return Originalwords;
}


public static int minutesDivision(int length , int totalmin){

if (totalmin == 0){
return totalmin / length;
}

return length / totalmin; 
}




public static String [] fillUp(String [] words){
String [] newArray = new String[addTestToList().length];

for (int count = 0; count < words.length; count++){

newArray[count] = words[count].strip();

} 
return newArray;

}



public static String [] biggerLength(String [] words){
String [] newArray = new String[words.length];

for (int count = 0; count < addTestToList().length; count++){

newArray[count] = addTestToList()[count].strip();

} 
return newArray;

}

public static String [] strpBiggerLength(String [] words){
String [] newArray = new String[words.length];

for (int count = 0; count < words.length; count++){

newArray[count] = words[count].strip();

} 
return newArray;

}




}