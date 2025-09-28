from item import Item

class DVD(Item):
    def __init__(self, name, published_year,duration):
        super().__init__(name, published_year)
        self.duration=duration
        
    def late_fee_calculation(self,days):
        super.fees=super.fees+0.11*days
        return super.fees
    def overdue_notification(self):
        print("notification for late ")
        return True
    def print_details(self):
        print(f"book name {self.name} , duration : {self.duration}")
        
    def run_dvd(self):
        print("dvd is running")    