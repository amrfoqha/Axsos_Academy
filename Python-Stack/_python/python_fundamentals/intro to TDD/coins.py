def coins(amount):
    mylist=[]
    quarters=amount // 25
    mylist.append(quarters)
    amount-=quarters*25
    dimes=amount//10
    mylist.append(dimes)
    amount-=dimes*10
    nickels=amount//5
    mylist.append(nickels)
    amount-=nickels*5
    mylist.append(amount)

    return mylist