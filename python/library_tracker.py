
available_list = []
def main_menu():

  user_input = int(input("""

Welcome user What are we doing today :)

1-> View all Book

2-> Borrow a Book

3-> Return a book

4-> Exit

"""))
  menu_functions(user_input)

def menu_functions(number):
   
    if number == 1:
      view_all_books()
      return
    elif number == 2:
      borrow_a_book()
      return 
    elif number == 3:
      return_a_book()
      return
    elif number == 4:
      print("Good bye fam")
    else:
      print("Invalid Input")

def view_all_books():
   print(f"{"Books":<55}{"STATUS"}")
   count = 0
   for books in list_of_books():

     print(f"{count+1}.{books:<55}{available_list[count]}")
     count+=1
   back_to_menu()


def borrow_a_book():
    count = 0
    print(f"{"BOOKS":<55}{"STATUS"}")
    for books in list_of_books():
     
     print(f"{count+1}.{books:<55}{available_list[count]}")
     count+=1
    option = int(input("\nSelect the  number of book u want to borrow\n"))
    if option - 1 >= len(available_list):
       print("This Book is Not Available Yet")
       back_to_menu()
       return
    elif available_list[option - 1] == "BORROWED":
        print(f"{list_of_books()[option - 1]} is already Borrowed")
        back_to_menu()
        return
    else:
       add_available_or_borrowed(option)
       print(f"{list_of_books()[option-1]} Borrowed Sucessfully")
       back_to_menu() 
       return



def return_a_book():
    count = 0
    print(f"{"BOOKS":<55}{"STATUS"}")
    for books in list_of_books():
     
     print(f"{count+1}.{books:<55}{available_list[count]}")
     count+=1
    option = int(input("\nSelect the  number of book you want to return\n"))
    if option - 1 >= len(available_list):
       print("This Book is Not Avialble Yet")
       back_to_menu()
       return
    elif available_list[option - 1] == "AVAILABLE":
        print(f"{list_of_books()[option - 1]} is already Available")
        back_to_menu()
        return
    else:
       add_available_or_borrowed(option)
       print(f"{list_of_books()[option-1]} Returned Sucessfully")
       back_to_menu() 
       return















def back_to_menu():
  
   options = int(input("""

press>>>>>

  1-> Main Menu
  0-> Quit
"""))
   if options == 1:
      main_menu()
      return
   elif options == 0:
      print("Good Bye fam")  
   else:
      print("Invalid Input")
   


def add_available_to_all():

    for numbers in range(10):
       available_list.append("AVAILABLE")
      
     
def add_available_or_borrowed(index):
   
   number = index - 1
   if available_list[number] != "AVAILABLE":
      available_list[number] = "AVAILABLE"
      return "This Book is Available Now"
   else:
      available_list[number] = "BORROWED"
      return "Borrowed Sucessfully"
      



def list_of_books():
    
  list_of_Books = [
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
]
  return list_of_Books 


add_available_to_all()
main_menu()




















