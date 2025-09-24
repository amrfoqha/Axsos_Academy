import unittest


def is_number(value):
    if(str(value).isnumeric()):
        return True
    else: 
        return False



# print(is_number('1234'))

class is_number_test(unittest.TestCase):
    def testchar(self):
        self.assertEqual(is_number('A'),False)

    def test2(self):
        self.assertEqual(is_number("12t"),False)

    def test3(self):
        self.assertEqual(is_number("1234"),True)      

    def test4(self):
        self.assertEqual(is_number(66),True)           

if __name__ == '__main__':
    unittest.main() # this runs our tests    




