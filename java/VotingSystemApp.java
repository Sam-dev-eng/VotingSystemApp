import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class VotingSystemApp{
public static ArrayList<String> votersName = new ArrayList<String>();
public static ArrayList<Long> votersNumber = new ArrayList<Long>();
public static ArrayList<String> candidateName = new ArrayList<String>();
public static ArrayList<String> candidateShortPartyName = new ArrayList<String>();
public static ArrayList<String> candidateFullPartyName = new ArrayList<String>();
public static ArrayList<Long> uniqueVotingNumber = new ArrayList<Long>();
public static ArrayList<Integer> numberOfParticipants = new ArrayList<Integer>();
public static ArrayList<Long> usedIdNumbers = new ArrayList<Long>();
public static ArrayList<Integer> storeVotersCount = new ArrayList<Integer>();
static Scanner scanner = new Scanner (System.in);
static long totalMililSecondNow = System.currentTimeMillis();
static long totalCurrentSecondNow = totalMililSecondNow / 1000;
static LocalDateTime today = LocalDateTime.now();
public static void main(String[] args){


mainMenu();

}
public static void mainMenu(){

String menu = """

Hello user What are we doing today... :)

    press->>

1-> Resgister your party

2-> Voters Registration

3-> Cast your Vote

4-> Check live Number of Voters

5-> Check Final Result
""";
System.out.println(menu);
int input = scanner.nextInt();
scanner.nextLine();
switch (input){

case 1:
	System.out.println(addCanditates());
	backToMain();
	
break;

case 2:
	System.out.println(registerVoters());
	backToMain();
break;

case 3:System.out.println(castingVotes());
	backToMain();
break;

case 4: displayVoteCounting();
	backToMain();
break;

case 5: System.out.println(showResult());
	backToMain(); 
break;

default: System.out.println("Invalid Input");
}

}



public static void backToMain(){
System.out.println("""

Press 0-> mainMenu
press 1-> quit 

""");
int backward = scanner.nextInt();
switch (backward){

	case 0:mainMenu();
	break;

	case 1:System.out.println("GoodBye fam");
	break;
	
	default:showResult(); 
		System.out.println("Invalid Input");

}


}







public static String addCanditates(){

if (timeToEnd(120) == true){
return "The registration portal is closed\n\nGo to voters Registration"; 
}
System.out.println("Enter your name");
String nameOfCandidate = scanner.nextLine();
String upperCase = nameOfCandidate.toUpperCase();

if (candidateName.contains(upperCase) == true){
return "This Candidate name has already been registered";
}
System.out.println("Enter Your FuLL Party Name");
String partyName = scanner.nextLine();
String partyUpperCase  = partyName.toUpperCase();
if (candidateFullPartyName.contains(partyUpperCase) == true){
return "This party name has already been used";
}
System.out.println("Enter the short name for your party eg.(APC)");	
String partyShortName = scanner.nextLine();
String shortNameUpper = partyShortName.toUpperCase();
if (candidateShortPartyName.contains(shortNameUpper) == true){
return "This party name has already been used";
}
candidateName.add(upperCase);
candidateFullPartyName.add(partyUpperCase);
candidateShortPartyName.add(shortNameUpper);
storeVotersCount.add(0);
return "Added Sucessfully Good Luck to You";
}






public static String registerVoters(){

String startTime = today.plusMinutes(2).format(DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a"));
if (timeToStart(120) == true){
return "The registration portal is not yet Opened\n\nit will probably open by "+startTime; 
}else
if (timeToEnd(240) == true)return "The registration portal is closed";
System.out.println("Enter your name");
String nameOfVoter = scanner.nextLine();
String nameToUpper = nameOfVoter.toUpperCase(); 
if (votersName.contains(nameToUpper) == true){
return "Candidate name have already been used";
}
System.out.println("Enter your age");
int ageOfVoter = scanner.nextInt();

if (ageValidator(ageOfVoter) == false){
return "You are not eligibel to vote yet";
}
System.out.println("Enter your Nationality");
String nationalityOfVoter = scanner.next();

if (nationalityValidator(nationalityOfVoter) == false){
return "Get out of this country!!";
}
long uniqueNumber = generateRadomNumber();
votersName.add(nameToUpper);
votersNumber.add(uniqueNumber);
return "Your registration Number is "+ uniqueNumber+"\n\nplease copy the number, you will be asked for it when voting";

 
}



public static long generateRadomNumber(){


long numberOne = 0;
long numberTwo = 0;
long number = 0;
uniqueVotingNumber.add(number);
while (uniqueVotingNumber.contains(number) != false){

numberTwo = (long)(Math.random() * 1000)* 1907;
numberOne = (long)(Math.random() * 1000) * 198;

number = numberTwo * numberOne;

}

uniqueVotingNumber.add(number);
return number;
}






public static boolean ageValidator(int age){

return age >= 18;

}


public static boolean nationalityValidator(String nationality){

String upperCase = nationality.toUpperCase();

return upperCase.equals("NIGERIA");
}





public static String castingVotes(){
String startTime = today.plusMinutes(4).format(DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a"));
if (timeToStart(240) == true){
return "The voting portal is not yet Opened\n\nProbably opening by "+startTime ; 
}else
if (timeToEnd(360) == true)return "The Voting portal is closed\n\nCheck for Final Results";

System.out.println("Enter your Voters Id Number");
long idNumber = scanner.nextLong();
scanner.nextLine();
System.out.println("Enter your registered name");
String regName = scanner.nextLine();
String regNameUpper = regName.toUpperCase();

if (checkIdOwner(regNameUpper,idNumber) != true){
return "You be thief no be you get this code aswer";

}
checkIdOwner(regNameUpper,idNumber);
if(usedIdNumbers.contains(idNumber) == true){
return "The number has already been used";
}
usedIdNumbers.add(idNumber);

if (validateId(idNumber) != true){
return "Invalid ID number";
}
if (candidateShortPartyName.size() == 0){
return "There's no parties registered for now";
}

System.out.println(displayPerticipants());

int numberOfVotedCandidate = scanner.nextInt();
int number = storeVotersCount.get(numberOfVotedCandidate - 1) + 1; 
int previous = storeVotersCount.remove(numberOfVotedCandidate - 1); 
storeVotersCount.add(numberOfVotedCandidate - 1,number);

return "Thank You For Voting shaa but LP must win ";

}



public static boolean validateId(long number){

return uniqueVotingNumber.contains(number);

}


public static String displayPerticipants(){
System.out.println("Available parties are...");
for (int count = 0; count < candidateShortPartyName.size(); count++){

System.out.printf("%d."+candidateShortPartyName.get(count)+"\t",count+1);
}
return "\n\nEnter the number of the candidate you want to vote";
}


public static boolean checkIdOwner(String name, long idNumber){

return votersName.indexOf(name) == votersNumber.indexOf(idNumber);

}



public static void displayVoteCounting(){
for (int count = 0; count < candidateShortPartyName.size(); count++){
System.out.print(candidateShortPartyName.get(count)+"\t\t");

}
System.out.println("");

for (int count = 0; count < storeVotersCount.size(); count++){
System.out.print(storeVotersCount.get(count)+"\t\t");

}
System.out.println("\n\nStill counting in progress");

}


public static String showResult(){
String startTime = today.plusMinutes(6).format(DateTimeFormatter.ofPattern("dd-MMM-yy hh:mm:ss a"));;
if (timeToStart(360) == true){
return "The Final result portal is not yet Opened\n\nVoting will End in "+ startTime; 
}
if(storeVotersCount.isEmpty() == true){
return "No Candidate applied for the Election";

}
int winner = storeVotersCount.get(0);
String PartyWinner = candidateShortPartyName.get(0); 
System.out.print("Parties\tTotal Votes\n");
for (int count = 0; count < candidateShortPartyName.size(); count++){
System.out.print("\t"+candidateShortPartyName.get(count)+"\t"+storeVotersCount.get(count)+"\n");
if (storeVotersCount.get(count) > winner){
winner  = storeVotersCount.get(count);
PartyWinner = candidateShortPartyName.get(count); 
}


}
return "\n\nThe Winner for this election is "+PartyWinner+" Scoring "+winner;


}


public static boolean timeToStart(int number){
long totalMililSec = System.currentTimeMillis();
long totalSecondForAdd = totalMililSec / 1000;

return totalSecondForAdd - totalCurrentSecondNow < number;
}





public static boolean timeToEnd(int number){
long totalMililSec = System.currentTimeMillis();
long totalSecondForEnd = totalMililSec / 1000;

return totalSecondForEnd - totalCurrentSecondNow > number;
}









}