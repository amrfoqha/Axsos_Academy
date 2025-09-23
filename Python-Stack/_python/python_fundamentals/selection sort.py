



def sort_list(unsorted):
    length=len(unsorted)
    for i in range(length-1):
        i_minval=i
        for j in range(i+1,length):
            if(unsorted[j]<unsorted[i_minval]):
                i_minval=j
                if(i_minval!=i):
                    unsorted[i_minval],unsorted[i]=unsorted[i],unsorted[i_minval]
    return unsorted

unsorted=[4,6,5,3,2,7,9,8,1]
sorted=sort_list(unsorted)
print(sorted)