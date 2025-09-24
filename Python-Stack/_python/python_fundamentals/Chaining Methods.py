class User:
    def __init__(self,fname,lname,id):
        self.fname=fname
        self.lname=lname
        self.id=id
        self.balance=0

    def make_withdrawal(self, amount):
        self.balance=self.balance-amount
        return self

    def make_deposit(self,amount):
        self.balance=self.balance+amount
        return self

    def display_user_balance(self):
        print(f"{self.fname} {self.lname} your balance is {self.balance}$ ") 
        return self   

    def transfer_money(self, other_user, amount):
        if self.id != other_user.id:
            self.make_withdrawal(amount)
            other_user.make_deposit(amount)
            print(f"Transfer Successful. transfer {amount}$ from [{self.fname} {self.lname}] --to-> [{other_user.fname} {other_user.lname}]")
            return self
        print(f"[{self.fname} {self.lname}] you can't transfer money to your self")
        return self
        
        


ahmad=User("ahmad","nofal",123)
omar=User("omar","ahmad",124)
amr=User("amr","foqha",125)
amr.make_deposit(500).make_deposit(200).make_deposit(300).make_withdrawal(350).display_user_balance()
omar.make_deposit(1100).make_deposit(200).make_withdrawal(150).make_withdrawal(450).display_user_balance()
ahmad.make_deposit(950).make_withdrawal(50).make_withdrawal(150).make_withdrawal(450).display_user_balance()

omar.transfer_money(amr,300)
amr.transfer_money(ahmad,100)
ahmad.transfer_money(ahmad,50)
omar.display_user_balance()
amr.display_user_balance()
ahmad.display_user_balance()





