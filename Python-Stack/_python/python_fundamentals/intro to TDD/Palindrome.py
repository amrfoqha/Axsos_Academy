import unittest

def reverse_str(str):
        mylist_list=list(str)
        for i in range(len(mylist_list)//2):
                mylist_list[i],mylist_list[len(mylist_list)-1-i]=mylist_list[len(mylist_list)-1-i],mylist_list[i]
        return "".join(mylist_list)

def isPalindrome(val):
    if(val == reverse_str(val)):return True
    return False

# print(isPalindrome("ractecar"))


class Test_isPalindrome(unittest.TestCase):
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

if __name__ == '__main__':
    unittest.main()            