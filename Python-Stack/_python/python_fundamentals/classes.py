class amr():
    def __init__(self,name="amr",phone="0594595311",available_balance=0):
        self.name=name
        self.phone=phone
        self.available_balance=available_balance
    def __str__(self):
        return f"person name is {self.name} , phone number is {self.phone} , and it balance in account is {self.available_balance}$"    


person=amr()
person.phone="0568632229"
print(person.phone)

person1=amr("ameer","0568632229",50)
print(person1)