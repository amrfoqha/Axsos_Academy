class Node:
    def __init__(self,num,char):
        self.char=char
        self.num=num
        self.next=None

    def __str__(self):
        return f"[Char,Num][{self.char},{self.num}]"    

# node1=Node(123)  
# print(node1.data)