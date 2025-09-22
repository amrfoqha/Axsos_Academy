def biggie_size(my_list):
    for i in range(0,len(my_list),1):
        if(my_list[i]>0):
            my_list[i]="big"
    return my_list
print(biggie_size([-1, 3,4,-2, 5, -5]))



def count_positives(my_list):
    count=0
    for i in range(0,len(my_list),1):
        if(my_list[i]>0):
            count+=1
    my_list[len(my_list)-1]=count       
    return my_list
print(count_positives([1,6,-4,-2,-7,-2]))

def sum_total(my_list):
    sum=0
    for el in my_list:
        sum+=el
    return sum
print(sum_total([1,2,3,4]))

def average(my_list):
    sum=0
    for el in my_list:
        sum+=el
    return sum/len(my_list)
print(average([1,2,3,4]))

def length(my_list):
    return len(my_list)

print(length([37,2,1,-9]) )


def maximum(my_list):
    if(len(my_list)==0):return False
    max=my_list[0]
    for el in my_list:
        if(el>max):
            max=el
    return max
print(maximum([2,2,1,40,-9,37]))

def minimum(my_list):
    if(len(my_list)==0):return False
    min=my_list[0]
    for el in my_list:
        if(el<min):
            min=el
    return min
print(minimum([2,2,1,40,-9,37]))

def ultimate_analysis(my_list):
    return {'sumTotal': sum_total(my_list), 'average': average(my_list), 'minimum': minimum(my_list), 'maximum': maximum(my_list), 'length': length(my_list) }


print(ultimate_analysis([37,2,1,-9]) )

def reverse_list(my_list):
    for i in range(len(my_list)//2):
       my_list[i],my_list[len(my_list)-1-i]=my_list[len(my_list)-1-i],my_list[i]
       
    return my_list

print(reverse_list([37,2,1,-9]))