def move_zero_numbers(list_of_numbers):
    new_list = []
    for elements in list_of_numbers:
        if elements != 0:
            new_list.append(elements)
    for elements in list_of_numbers:
        if elements == 0:
            new_list.append(elements)
    return new_list


numbers = [1,0,0,0,0,0,0,9,0,3,9]
print(move_zero_numbers(numbers))
