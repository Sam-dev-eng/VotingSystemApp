//const prompt = require('prompt-sync')();
let available = [];

function mainMenu(){

let menu = prompt(`

Welcome user what are we doing today :)

1-> View all Book

2-> Borrow a Book

3-> Return a Book

4-> Exit

`);

switch(menu){

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


function viewAllBooks(){

for (let count = 0; count < listOfBooks().length; count++){

console.log(`${count+1}.${listOfBooks()[count]}`);
}

}



function returnABook(){
console.log(`
${"Status"}          ${"Books"}
====================================================================
\n`);
for (let count = 0; count < listOfBooks().length; count++){
console.log(available[count]);
console.log(`   ${count+1}. ${listOfBooks()[count]}`);

}

let returnBook = prompt("\nSelect the number of book u want to Return");

if (available[returnBook - 1] == "Available") return "Please go to the Borrow Menu";  
availableOrBorrowed(returnBook);
return listOfBooks()[returnBook - 1]+"! Returned Sucessfully";
}




function borrowABook(){
console.log(`
${"Status"}          ${"Books"}
====================================================================
\n`);
for (let count = 0; count < listOfBooks().length; count++){
console.log(available[count]);
console.log(`   ${count+1}. ${listOfBooks()[count]}`);

}

let borrowBook = prompt("\nSelect the number of book u want to Borrow");

if (available[returnBook - 1] == "Available") return "Please go to the Available Menu";  
availableOrBorrowed(borrowBook);
return listOfBooks()[borrowBook - 1]+"! Returned Sucessfully";
}





function backToMain(){

let option = prompt(`

Press>>>>>>
  1-> Main Menu
  2-> Quit
`);


switch (option){

	case 1:mainMenu();
break;
	case 2:console.log("GoodBye fam");
break;
	default: console.log("Invalid input");
}

}








function addAvailableToAll(){


for (let count = 0; count < available.length; count++){

available[count] = "Available";

}

}



function availableOrBorrowed(index){
  
let number = index - 1;                        
if (available[number] != "Available"){
available[number] = "Available";
return "This Book is Available Now";

}else {
available[number] = "Borrowed ";

return "Borrowed Sucessfully";
}

}

function listOfBooks(){
listOfBooks = [
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
];
return listOfBooks;
}


//addAvailableToAll();
//mainMenu();





