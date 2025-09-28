class Node:
    def __init__(self,num):
        self.num=num
        self.next=None

    def __str__(self):
        return f"[Num][{self.num}]"    

# node1=Node(123)  
# print(node1.data)