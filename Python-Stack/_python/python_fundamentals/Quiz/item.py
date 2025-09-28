class Item():
    def __init__(self,name,published_year):
        self.name=name
        self.published_year=published_year
        self.is_available=True
        self.fees=0
        
    def borrow(self):
            if(self.is_available):
                print(f"{self.name} is borrowed")
                self.is_available=False
                self.fees=20
            else:print(f"{self.name} is already borrowed")  
        
    def returning(self):
            if(not self.is_available):
                print(f"{self.name} is returned")
                self.is_available=True
                self.fees=0
            else:   print(f"{self.name} is already available you cannot return it")  
        
    def checking_availability(self):
            if(self.is_available):
                print(f"{self.name} is available")
                return True
            print(f"{self.name} is not available")
            return False
        
    def late_fee_calculation(self,days):
            self.fees=self.fees+0.1*days
            return self.fees
        
    def overdue_notification(self):
            print("notification for late ")
            return True
    def print_details(self):   
        print(f"book name {self.name} , published_year : {self.published_year}"+ "available" if self.is_available else "not available")    
            
                
                
        
        
        