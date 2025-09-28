from lion import Lion
from monkeys import Monkey
from bears import Bear


x1=Lion("Simba",7,98,67,60,200,"africa")
x2=Monkey("Baboon",12,60,90,120,2,True)
x3=Bear("winnie the bo",7,98,67,"white","panda",300)

x1.make_sound()
x1.feed()
x1.display_info()
print("...........................")
x2.feed()
x2.display_info()
print("...........................")
x3.feed()
x3.catch_fish()
x3.display_info()