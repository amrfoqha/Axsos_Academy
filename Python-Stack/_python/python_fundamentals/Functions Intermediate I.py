import random
def randInt(min=0   , max=100   ):
    if(min < max and max>0 and min >= 0 and min != max):
        num = random.random()
        return round(num * (max-min) + min)
    return "please enter an valid parameters"


print(randInt())             # should print a random integer between 0 to 100
print(randInt(max=50))         # should print a random integer between 0 to 50
print(randInt(min=50))         # should print a random integer between 50 to 100
print(randInt(min=50, max=500))    # should print a random integer between 50 and 500