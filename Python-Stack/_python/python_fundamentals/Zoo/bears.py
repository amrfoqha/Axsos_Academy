from animals import Animal

class Bear(Animal):
    def __init__(self, name, age, health_level, happiness_level,color,type,weight):
        super().__init__(name, age, health_level, happiness_level)
        self.color=color
        self.type=type
        self.weight=weight
    def catch_fish(self):
        print(f"{self.name} catching fishes")
        
        