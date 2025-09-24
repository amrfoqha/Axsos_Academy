from BankAccount import Bankaccount
class User:
    def __init__(self,fname,lname):
        self.fname=fname
        self.lname=lname
        self.accounts=[Bankaccount(1)]

    def create_new_bankaccount(self,balance=0):
        length=len(self.accounts)
        new_id=self.accounts[length-1].account_id + 1
        self.accounts.append(Bankaccount(new_id,balance))
        return self
            
        

    def make_withdrawal(self, amount,account_id):
        for i in range(len(self.accounts)):
            if(self.accounts[i].account_id==account_id):
               self.accounts[i].withdraw(amount)  
        return self

    def make_deposit(self,amount,account_id):
        for i in range(len(self.accounts)):
            if(self.accounts[i].account_id==account_id):
               self.accounts[i].deposit(amount)  
        return self

    def display_user_balance(self):
        print(f"{self.fname} {self.lname} your ")
        for el in self.accounts:
            el.display_account_info()

        return self


    def transfer_money(self,sender_account_id, other_user,receiver_account_id, amount):
        self.make_withdrawal(amount,sender_account_id)
        other_user.make_deposit(amount,receiver_account_id)
        print(f"Transfer Successful. transfer {amount}$ from user {self.fname} Account_id [{sender_account_id}] --to-> {other_user.fname} Account_id [{receiver_account_id}]")
        
        return self
        



amr=User("amr","foqha").create_new_bankaccount().make_deposit(300,1).make_deposit(400,2).make_withdrawal(140,2).make_withdrawal(20,1).display_user_balance()
ahmad=User("ahmad","nofal").create_new_bankaccount().make_deposit(950,1).make_withdrawal(50,1).make_deposit(350,2).make_withdrawal(150,2).display_user_balance()
ahmad.transfer_money(1,amr,2,120)
amr.display_user_balance()
ahmad.display_user_balance()
# amr=User("amr","foqha")
# amr.make_deposit(500)
# amr.make_deposit(200)
# amr.make_deposit(300)
# amr.make_withdrawal(350)
# amr.display_user_balance()

# omar=User("omar","ahmad")
# omar.make_deposit(1100)
# omar.make_deposit(200)
# omar.make_withdrawal(150)
# omar.make_withdrawal(450)
# omar.display_user_balance()

# ahmad=User("ahmad","nofal")
# ahmad.make_deposit(950)
# ahmad.make_withdrawal(50)
# ahmad.make_withdrawal(150)
# ahmad.make_withdrawal(450)
# ahmad.display_user_balance()

# omar.transfer_money(amr,300)
# amr.transfer_money(ahmad,100)
# omar.display_user_balance()
# amr.display_user_balance()
# ahmad.display_user_balance()