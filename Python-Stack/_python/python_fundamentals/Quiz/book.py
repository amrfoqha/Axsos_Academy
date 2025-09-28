from item import Item

class Book(Item):
    def __init__(self,name,author,edition,published_year):
        super().__init__(name,published_year)
        self.author=author
        self.edition=edition
        
       
        
    def late_fee_calculation(self,days):
        super().fees=super().fees+0.1*days
        return super().fees
    
    def overdue_notification(self):
        print("notification for late ")
        return True
    def print_details(self):
        print(f"book name {self.name} , author name : {self.author}")    
        
        
           
    