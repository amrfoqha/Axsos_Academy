import unittest
def reverse_list(list):
        for i in range(len(list)//2):
                list[i],list[len(list)-1-i]=list[len(list)-1-i],list[i]
        return list
# print(reverse_list([[1,3,5],[5,3,1]]))

def reverse_str(str):
        mylist_list=list(str)
        for i in range(len(mylist_list)//2):
                mylist_list[i],mylist_list[len(mylist_list)-1-i]=mylist_list[len(mylist_list)-1-i],mylist_list[i]
        return "".join(mylist_list)

def isPalindrome(val):
    if(val == reverse_str(val)):return True
    return False


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


def factorial(i):
    if(i==0):return 1
    if(i==1):return 1
    return i*factorial(i-1)

def fibonacci(n):
    if(n==0):return 0 
    if(n==1):return 1
    return fibonacci(n-1)+fibonacci(n-2)



class Test_All_Func(unittest.TestCase):
        def test1_reverse_list(self):
            self.assertEqual(reverse_list([1,3,5]), [5,3,1])
        def test2_reverse_list(self):
            self.assertEqual(reverse_list([]), [])
        def test3_reverse_list(self):
            self.assertEqual(reverse_list([[1,3,5],[5,3,1]]), [[5,3,1],[1,3,5]])


        def test1_isPalindrome(self):
            self.assertEqual( isPalindrome("racecar"), True )
        def test2_isPalindrome(self):
            self.assertEqual( isPalindrome(""), True )
        def test3_isPalindrome(self):
            self.assertEqual( isPalindrome("12321"), True )
        def test4_isPalindrome(self):
            self.assertEqual( isPalindrome("a"), True )    
        def test5_isPalindrome(self):
            self.assertEqual( isPalindrome(" "), True )        

        def test1_coins(self):
            self.assertEqual( coins(87), [3,1,0,2] )
        def test2_coins(self):
            self.assertEqual( coins(50), [2,0,0,0] )
        def test3_coins(self):
            self.assertEqual( coins(7), [0,0,1,2] )
        def test4_coins(self):
            self.assertEqual( coins(0), [0,0,0,0] )    
        def test5_coins(self):
            self.assertEqual( coins(-1), False ) 

        def test1_factorial(self):
            self.assertEqual( factorial(0), 1 )
        def test2_factorial(self):
            self.assertEqual( factorial(1), 1 )
        def test3_factorial(self):
            self.assertEqual( factorial(5), 120 )  
        def test4_factorial(self):
            self.assertEqual( factorial(-1),  False )      

        def test1_fibonacci(self):
            self.assertEqual( fibonacci(10), 55 )
        def test2_fibonacci(self):
            self.assertEqual( fibonacci(0), 0 )
        def test3_fibonacci(self):
            self.assertEqual( fibonacci(-1), False )  

            

            
                 

if __name__ == '__main__':
    unittest.main()            