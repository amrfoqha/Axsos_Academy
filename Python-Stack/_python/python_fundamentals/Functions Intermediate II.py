x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]



# Change the value 10 in x to 15. Once you're done, x should now be [ [5,2,3], [15,8,9] ].
x[1][0]=15
print(x)


print("...............................................................................")
# Change the last_name of the first student from 'Jordan' to 'Bryant'
students[0]["last_name"]="Bryant"
print(students)


print("...............................................................................")
# In the sports_directory, change 'Messi' to 'Andres'
sports_directory["soccer"][0]="Andres"
print(sports_directory)


print("...............................................................................")
# Change the value 20 in z to 30
z[0]["y"]=30
print(z)

print("...............................................................................")
# Iterate Through a List of Dictionaries
for el in students:
        for key,value in el.items():
            print(f"{key} : {value}",end=" ") 
        print("")            


# Create a function iterateDictionary(some_list) that, given a list of dictionaries,
#  the function loops through each dictionary in the list and prints each key and the associated value.
#  For example, given the following list:

students = [
         {'first_name':  'Michael', 'last_name' : 'Jordan'},
         {'first_name' : 'John', 'last_name' : 'Rosales'},
         {'first_name' : 'Mark', 'last_name' : 'Guillen'},
         {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]

print("...............................................................................")
def iterateDictionary(students):
    for el in students:
        for key,value in el.items():
            print(f"{key} - {value}",end=", ") 
        print("")
iterateDictionary(students)

# Get Values From a List of Dictionaries
print("...............................................................................")
def iterateDictionary(students):
    for el in students:
        for value in el.values():
            print(value) 

        
iterateDictionary(students)
print("...............................................................................")
def iterateDictionary2(key_name, some_list):
     for el in some_list:
          for key,value in el.items():
               if key==key_name:
                    print(value) 
iterateDictionary2('first_name', students) 
print("...............................................................................")
iterateDictionary2('last_name', students) 





dojo = {
   'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
   'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
# Iterate Through a Dictionary with List Values
for el in dojo.items():
     print(el)

print("...............................................................................")

def printInfo(some_dict):
     for key , values in some_dict.items():
        print(f"{len(values)} {key}")
        for el in values:
            print(el)
        print("")    

printInfo(dojo)        
       