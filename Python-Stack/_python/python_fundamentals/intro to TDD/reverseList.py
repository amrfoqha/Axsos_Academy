import unittest
def reverse_list(list):
        for i in range(len(list)//2):
                list[i],list[len(list)-1-i]=list[len(list)-1-i],list[i]
        return list
# print(reverse_list([[1,3,5],[5,3,1]]))

class Test_Reverse_List(unittest.TestCase):
        def test1(self):
            self.assertEqual(reverse_list([1,3,5]), [5,3,1])
        def test2(self):
            self.assertEqual(reverse_list([]), [])
        def test3(self):
            self.assertEqual(reverse_list([[1,3,5],[5,3,1]]), [[5,3,1],[1,3,5]])

if __name__ == '__main__':
    unittest.main()            