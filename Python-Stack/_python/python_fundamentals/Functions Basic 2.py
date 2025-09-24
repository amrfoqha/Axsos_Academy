def count_down(num):
    my_list=[]
    for i in range(num,0-1,-1):
        my_list.append(i)

    return my_list    


print(count_down(5))


def print_and_return(numbers):
    print(numbers[0]) 
    return numbers[1] 
result = print_and_return([1, 2])
print(f"Returned value: {result}")

def First_Plus_Length(my_list):
    return my_list[0]+len(my_list)

print(First_Plus_Length([2,2,3,4,5]))



def values_greater_than_second(list):
    newlist=[]
    if(len(list)<=2):return False  
    else : 
        for el in list :
            if(el > list[1]):
                newlist.append(el)
    print(len(newlist))
    return newlist
y=values_greater_than_second([5,2,3,4,5,1])
print(y)
   
def  length_and_value(size,value):
    my_list=[]
    for i in range(size):
        my_list.append(value)
    return my_list    

print(length_and_value(4,7))