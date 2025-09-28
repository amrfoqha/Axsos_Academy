from animals import Animal

class Lion(Animal):
    def __init__(self,name,age,health_level,happiness_level,speed,power,location):
        super().__init__(name,age,health_level,happiness_level)
        self.speed=speed
        self.power=power
        self.location=location
    def make_sound(self):
        print(f"this is a {self.name} sound")    
