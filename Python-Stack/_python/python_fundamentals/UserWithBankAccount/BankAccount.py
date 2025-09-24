class Bankaccount:
    def __init__(self,id,balance=0):
        self.balance=balance
        self.account_id=id
        self.interest_rate=0.01 
     
    def deposit(self,amount):
        self.balance+=amount
        return self
    def withdraw(self,amount):
        if self.balance<amount:
            self.balance-=5
            print(f"Insufficient funds: Charging a $5 fee in this accountID = {self.account_id}")
            return self
        self.balance-=amount
        return self
    
    def display_account_info(self):
        print(f"account number {self.account_id} [ balance is {self.balance:.3f}$ ]")
        return self
    def yield_interest(self):
        if(self.balance>0):
            self.balance*=self.interest_rate + 1
            return self
        

# acc1=Bankaccount(1,0)
# acc2=Bankaccount(2,50)


# # To the first account, make 3 deposits and 1 withdrawal,
# #  then yield interest and display the account's info all in one line of code (i.e. chaining)
# acc1.deposit(50).deposit(190).deposit(70).withdraw(96).display_account_info().yield_interest().display_account_info()

# # To the second account, make 2 deposits and 4 withdrawals,
# #  then yield interest and display the account's info all in one line of code (i.e. chaining)
# acc2.deposit(270).deposit(310).withdraw(120).withdraw(135).display_account_info().yield_interest().display_account_info()

    