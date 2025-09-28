class Animal():
    def __init__(self,name,age,health_level,happiness_level):
        self.name=name
        self.age=age
        self.health_level=health_level
        self.happiness_level=happiness_level
    def display_info(self):
        print(f"{self.name} health : {self.health_level} happiness : {self.happiness_level}")
    def feed(self):
        self.happiness_level+=10
        self.health_level+=10
        print(f"{self.name} get breakfast")
        
    
            
        
        
        