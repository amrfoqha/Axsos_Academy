from animals import Animal

class Monkey(Animal):
    def __init__(self, name, age, health_level, happiness_level,intelligent,tall,has_tail):
        super().__init__(name, age, health_level, happiness_level)
        self.intelligent=intelligent
        self.tall=tall
        self.has_tail=has_tail
        
        def parkour(self):
            print(f" {self.name} can do parkour sport")
        def make_shower(self):
            print(f'{self.name} is showering now')    