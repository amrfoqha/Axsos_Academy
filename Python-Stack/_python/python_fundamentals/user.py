class User:
    def __init__(self,fname,lname):
        self.fname=fname
        self.lname=lname
        self.balance=0

    def make_withdrawal(self, amount):
        self.balance=self.balance-amount

    def make_deposit(self,amount):
        self.balance=self.balance+amount

    def display_user_balance(self):
        print(f"{self.fname} {self.lname} your balance is {self.balance}$ ")    

    def transfer_money(self, other_user, amount):
        self.make_withdrawal(amount)
        other_user.make_deposit(amount)
        print(f"Transfer Successful. transfer {amount}$ from [{self.fname} {self.lname}] --to-> [{other_user.fname} {other_user.lname}]")
        




amr=User("amr","foqha")
amr.make_deposit(500)
amr.make_deposit(200)
amr.make_deposit(300)
amr.make_withdrawal(350)
amr.display_user_balance()

omar=User("omar","ahmad")
omar.make_deposit(1100)
omar.make_deposit(200)
omar.make_withdrawal(150)
omar.make_withdrawal(450)
omar.display_user_balance()

ahmad=User("ahmad","nofal")
ahmad.make_deposit(950)
ahmad.make_withdrawal(50)
ahmad.make_withdrawal(150)
ahmad.make_withdrawal(450)
ahmad.display_user_balance()

omar.transfer_money(amr,300)
amr.transfer_money(ahmad,100)
omar.display_user_balance()
amr.display_user_balance()
ahmad.display_user_balance()