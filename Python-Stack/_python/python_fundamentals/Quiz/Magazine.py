from item import Item

class Magazine(Item):
    def __init__(self, name,version,pages,language, published_year):
        super().__init__(name, published_year)
        self.version=version
        self.pages=pages
        self.language=language
        
    def late_fee_calculation(self,days):
        super().fees=super().fees+0.4*days
        return super.fees
    def overdue_notification(self):
        print("notification for late ")
        return True
    def print_details(self):
        print(f"book name {self.name} , version  : {self.version}")      
            
        