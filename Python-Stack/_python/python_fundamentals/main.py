print("hello world")

name = "Noelle!"
print("hello",name)
print("hello"+name)

num = 42
print( "Hello",num )   
print( "Hello"+str(num)  )



fave_food1 = "sushi"
fave_food2 = "pizza"
print("I love to eat {} and {}".format(fave_food1,fave_food2))
print(f"I love to eat {fave_food1} and {fave_food2}.")

message="I love to eat {} and {}.".format(fave_food1,fave_food2)
new_message=message.split(" ")
print(new_message)
print(type(message))
print(type(new_message))

print(message.upper())
