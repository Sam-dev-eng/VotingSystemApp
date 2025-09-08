import re
students_info = {}



def add_students():
  unique_user_name = input("Enter your USERNAME:\n")
  sorted_name = sort_unique_names(unique_user_name)
  if sorted_name == None:
    return  
  name = input("Enter your name:\n").title()
  age = int(input("Enter your age\n"))
  number_of_courses = int(input("How many courses do u Offer\n"))
  course = add_courses(number_of_courses)
  print("\nYour Adress>>>>>>")
  nationality = input("Enter your Nationality:\n").title()
  state = input("Your State of Origin:\n").title()
  city_or_town = input("Your City or Town:\n").title()
  zip_code = int(input("Enter your Zip code\n"))

  students_info[sorted_name] = {
  "name": name,
  "age": age,
  "course": course,
  "nationlaity": nationality,
  "state": state,
  "city_or_town": city_or_town,
  "zipcode": zip_code
   }
  menu()


def menu():
  menu_option = int(input("""
Press->
1 -> add Student
2 -> diplay students records
3 -> display Students courses
4 -> display Students Zipcodes
5 -> display Students Cities
                                 6-> Add a new course
                                 7-> remove course
                                 8-> Update Age
                                 9-> Update City OR Town
                                 10-> update Zip Code
                                 11-> update Country
     100-> Overall Students
0 -> Quit
   
"""))
  menu_options(menu_option)


def add_courses(number):
  
  set_of_courses = set()
  for numbers in range(number):
    add_course = input(f"Enter course {numbers + 1}\n").title()
    pattern = r"\b\w+\b"
    courses = "".join(re.findall(pattern ,add_course))
    validate_course = department_courses(courses)
    while validate_course != "Pass":
      print(department_courses(courses)) 
      add_course = input("Try Again\n").title()
      pattern = r"\b\w+\b"
      courses = "".join(re.findall(pattern ,add_course))
      validate_course = department_courses(courses)
    set_of_courses.add(courses)  
    
    
  return set_of_courses 



def back_to_main():

  number = int(input("""
  
Press>>>
   0 > menu
   1 > Quit
"""))
  if number == 0:
     menu()
  elif number == 1:
    print("Good bye fam")
  else: 
    print("Invalid input") 









def department_courses(each_course):
  pattern = r"\b\w+\b"
  course = "".join(re.findall(pattern ,each_course))
  department_courses = [ "Math",   "Physics",   "Computer Science",   "Biology",   "Chemistry", 
  "Statistics",    "English",    "Economics",    "History",    "Philosophy", 
  "Sociology",   "Political Science",    "Geography",   "Psychology",   "Art", 
  "Music",   "Engineering",   "Law",    "Medicine",    "Business"]

  if course in department_courses:
    return "Pass"
  for courses in department_courses:

     if course[:5:] == courses[:5:]:
       return "\nDo u mean "+courses+"?"
       
     elif course[:4:] == courses[:4:]:
       return "\nDo u mean "+courses+"?"
       
  for courses in department_courses:

     if courses[:3:] == course[:3:]:
       return "\nDo u mean "+courses+"?"
       
     elif courses[:2:] == course[:2:]:
       return "\nDo u mean "+courses+"?"

  for courses in department_courses:   
     
      if course[:1:] == courses[:1:]:
       return "\nYou dey university common spelling u no sabi!! God forbid\n\nDo u mean "+courses+"?"
       
       
  return "\nYour Department does not offer this course"





def menu_options(number):
   if number == 1:
     add_students()
   elif number == 2:
      display_student_records()
   elif number == 3:
      display_only_courses()
   elif number == 4:
       display_zip_code()
   elif number == 5:
       displa_city_Or_town()
   elif number == 6:
       add_a_new_course()
   elif number == 7:
     remove_existing_course()
   elif number == 8:
       update_age()
   elif number == 9:
       update_city()
   elif number == 10:
       update_zipcode()
   elif number == 11:
       update_nationality()
   elif number == 100:
        overall_number()
   elif number == 0:
     print("Good bye fam")
   else:
     print("invalid input")
     

def sort_unique_names(name):
   
   if name in students_info:
     print("This name already exist try again..\n\nyou can add numbers")
     add_students()
     return None
   else:
    return name






def display_student_records():
    print(f"{"name":<20}{"Age":<8}{"Country":<10}{"State":<10}{"City":<10}{"Zip":<10}{"Course"}")
    print("=" * 120,"\n")
    for keys in students_info:
      name = students_info[keys]["name"]
      age =  students_info[keys]["age"]
      course = ", ".join(students_info[keys]["course"])
      nationality = students_info[keys]["nationlaity"] 
      state = students_info[keys]["state"]
      city_or_town = students_info[keys]["city_or_town"]  
      zipcode = students_info[keys]["zipcode"]
      print(f"{name:<20}{age:<8}{nationality:<10}{state :<10}{city_or_town :<10}{zipcode:<10}{course}")
    back_to_main()
    return


def display_only_courses():

    print(f"{"Name":<20}{"course"}")
    print("=" * 50,"\n")
    for keys in students_info:
      name = students_info[keys]["name"]
      course = ", ".join(students_info[keys]["course"])
      print(f"{name:<20}{course}")
    back_to_main()
    return
    

def display_zip_code():

    print(f"{"Name":<20}{"Zip Code"}")
    print("=" * 50,"\n")
    for keys in students_info:
      name = students_info[keys]["name"]
      zipcode = students_info[keys]["zipcode"]
      print(f"{name:<20}{zipcode}")
    back_to_main()
    return 

def displa_city_Or_town():

    print(f"{"Name":<20}{"City"}")
    print("=" * 50,"\n")
    for keys in students_info:
      name = students_info[keys]["name"]
      city_or_town = students_info[keys]["city_or_town"]
      print(f"{name:<20}{city_or_town}")
    back_to_main()
    return 

def add_a_new_course():
    if len(students_info) == 0:
     print("Theirs no Student added yet")
     back_to_main()
     return
    while True:
      user_name = input("Enter your USERNAME\n")
      if user_name in students_info:
        number_of_course = int(input("How many courses do you want to add\n"))
        for numbers in range(number_of_course):
         courses = input(f"Enter course {numbers + 1}\n").title()
         validate_course = department_courses(courses)
         while validate_course != "Pass":
           print(department_courses(courses)) 
           courses = input("Try Again\n").title()
           validate_course = department_courses(courses)
         students_info[user_name]["course"].add(courses)
         print(f"{courses} Added Sucessfully")
        back_to_main()
        return 
      else:
          print("USERNAME NOT FOUND!!")    
    



def remove_existing_course():
    if len(students_info) == 0:
     print("Theirs no Student added yet")
     back_to_main()
     return
    while True:
      user_name = input("Enter your USERNAME\n")
      if user_name in students_info:
        number_of_course = int(input("How many courses do you want to remove\n"))
        for numbers in range(number_of_course):
         courses = input(f"Enter course {numbers + 1}\n").title()
         validate_course = department_courses(courses)
         while validate_course != "Pass":
           print(department_courses(courses)) 
           courses = input("Try Again\n").title()
           validate_course = department_courses(courses)
         students_info[user_name]["course"].remove(courses)
         print(f"{courses} removed Sucessfully\n")
        back_to_main()
        return 
      else:
          print("USERNAME NOT FOUND!!")






def update_age():
    if len(students_info) == 0:
     print("Theirs no Student added yet")
     back_to_main()
     return
    while True:
      user_name = input("Enter your USERNAME\n")
      if user_name in students_info:
        update_age = int(input("Enter your new age\n"))
        validate_age(update_age)
        students_info[user_name]["age"] = update_age
        print("New Age Added Sucessfully")
        back_to_main()
        return 
      else:
          print("USERNAME NOT FOUND!!")    
    
def validate_age(number):

  if type(number) != int:
    print("Try again")
    update_age()
    return
  return None





def update_city():
    if len(students_info) == 0:
     print("Theirs no Student added yet")
     back_to_main()
     return
    while True:
      user_name = input("Enter your USERNAME\n")
      if user_name in students_info:
        update_city = input("Enter your new City or town\n") 
        students_info[user_name]["city_or_town"] = update_city 
        print("New City Added Sucessfully")
        back_to_main()
        return 
      else:
          print("USERNAME NOT FOUND!!")
    



def update_zipcode():
    if len(students_info) == 0:
     print("Theirs no Student added yet")
     back_to_main()
     return
    while True:
      user_name = input("Enter your USERNAME\n")
      if user_name in students_info:
        update_zipcode = int(input("Enter your new Zip Code\n"))
        new_zip = invalid_zip(update_zipcode)
         
        students_info[user_name]["zipcode"] = new_zip  
        print("New Zip Code Added Sucessfully")
        back_to_main()
        return 
      else:
          print("USERNAME NOT FOUND!!")    
    

def invalid_zip(number):

  if type(number) != int:
    print("Try again")
    update_zipcode()
    return
  return number
       








def update_nationality():
    if len(students_info) == 0:
     print("Theirs no Student added yet")
     back_to_main()
     return
    while True:
      user_name = input("Enter your USERNAME\n")
      if user_name in students_info:
        update_country = input("Enter your new Country\n") 
        students_info[user_name]["nationlaity"] = update_country 
        print("New Country Added Sucessfully")
        back_to_main()
        return 
      else:
          print("USERNAME NOT FOUND!!")
    








def overall_number():
     count = 0
     print("\nSTUDENTS")
     print("=" * 50,"\n")
     for students in students_info:
       count += 1
       print(f"{count}. {students_info[students]["name"]}")
     print("=" * 50,"\n")
     print("Total Student",len(students_info))
     back_to_main()
     return 
 

      
menu()






