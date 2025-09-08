import java.util.*;
public class LibraryTracker{
static Scanner scanner = new Scanner(System.in);
public static String[] available = new String [10];

public static void main(String[] args){

addAvailableToAll();
mainMenu();
}

public static void mainMenu(){

String menu = """

Welcome user what are we doing today :)

1-> View all Book

2-> Borrow a Book

3-> Return a Book

4-> Exit

""";
System.out.println(menu);
int input = scanner.nextInt();

switch(input){

	case 1:viewAllBooks();
		backToMain();
break;
	case 2:System.out.println(borrowABook());
		backToMain();
break;
	case 3:System.out.println(returnABook());
		backToMain();
break;
	case 4: System.out.println("Good Bye Fam");
break;
	default: System.out.println("Invalid Input");


}
}


public static void viewAllBooks(){

for (int count = 0; count < listOfBooks().length; count++){

System.out.printf("%d. %s%n",count+1,listOfBooks()[count]);
}

}



public static String returnABook(){
System.out.printf("""
%s          %s
====================================================================
\n""","Status","Books");
for (int count = 0; count < listOfBooks().length; count++){
System.out.print(available[count]);
System.out.printf("    %d. %s%n",count+1,listOfBooks()[count]);

}

System.out.println("\nSelect the number of book u want to Return");
int returnBook = scanner.nextInt();

if (available[returnBook - 1].equals("Available")) return "Please go to the Borrow Menu";  
availableOrBorrowed(returnBook);

return listOfBooks()[returnBook - 1]+"! Returned Sucessfully";
}





public static String borrowABook(){
System.out.printf("""
%s          %s
====================================================================
\n""","Status","Books");
for (int count = 0; count < listOfBooks().length; count++){
System.out.print(available[count]);
System.out.printf("    %d. %s%n",count+1,listOfBooks()[count]);

}

System.out.println("\nSelect the number of book u want to borrow");
int borrow = scanner.nextInt();

if (available[borrow - 1].equals("Borrowed ")) return "Please go to the Available Menu";  
availableOrBorrowed(borrow);

return listOfBooks()[borrow - 1]+"! Borrowed Sucessfully";
}





public static void backToMain(){

String option = """

Press>>>>>>
  1-> Main Menu
  2-> Quit
""";
System.out.println(option);
int back = scanner.nextInt();

switch (back){

	case 1:mainMenu();
break;
	case 2:System.out.println("GoodBye fam");
break;
	default: System.out.println("Invalid input");
}

}








public static void addAvailableToAll(){


for (int count = 0; count < available.length; count++){

available[count] = "Available";

}
System.out.println(Arrays.toString(available));

}



public static String availableOrBorrowed(int index){
  
int number = index - 1;                        
if (available[number] != "Available"){
available[number] = "Available";
return "This Book is Available Now";

}else {
available[number] = "Borrowed ";

return "Borrowed Sucessfully";
}

}

public static String[] listOfBooks(){
String [] listOfBooks = {
"To Kill a Mockingbird",
"Pride and Prejudice",
"The Great Gatsby",
"Dune",
"The Lord of the Rings",
"The Black Girl's Guide to Financial Freedom",
"In Pursuit of purpose",
"The long Goodbye",
"The Silence of the lambs",
"The Unbearable Lightness of Being"
};
return listOfBooks;
}


}