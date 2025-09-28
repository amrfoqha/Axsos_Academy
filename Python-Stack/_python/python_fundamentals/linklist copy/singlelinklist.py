class Node:
    def __init__(self,val):
        self.val=val
        self.next=None 
    
class MyLinkedList(object):

    def __init__(self):
        self.head=None
        self.size=0
        

    def get(self, index):
        if index>=0 and index<self.size:
            current=self.head
            for i in range(index):
                current=current.next
            return current.val
        else:return -1
        
    def get_At(self,index):
        if index>=0 and index<self.size:
            current=self.head
            for i in range(index):
                current=current.next
            return current         
        

    def addAtHead(self, val):
        newnode=Node(val)
        newnode.next=self.head
        self.head=newnode       
        self.size+=1    
        return self
        

    def addAtTail(self, val):
        newnode=Node(val)
        if(not self.head):
            self.head=newnode
            self.size+=1
            return self
        current=self.head
        while(current.next):
            current=current.next
        current.next=newnode
        self.size+=1
        return self
        

    def addAtIndex(self, index, val):
        if index<0 or index>self.size:
            print("Please enter an valid value")
            return -1
        if(index==0):
            self.addAtHead(val)
            return self
        if index == self.size:
            self.addAtTail(val)
            return self
        previous_node=self.get_At(index-1)
        newnode=Node(val)
        newnode.next=previous_node.next
        previous_node.next=newnode
        self.size+=1
        return self
        

    def deleteAtIndex(self, index):
        if index<0 or index>=self.size:
            print("Please enter an valid value")
            return self
        if(index==0):
            self.head=self.head.next
            self.size-=1
            return self
        previuos_node=self.get_At(index-1)
        previuos_node.next=previuos_node.next.next
        self.size-=1
        return self
        


# Your MyLinkedList object will be instantiated and called as such:
obj = MyLinkedList()
# param_1 = obj.get(index)
obj.addAtHead(1)
obj.addAtTail(3)
obj.addAtIndex(1,2)
print(obj.get(0),obj.get(1),obj.get(2))
print(".......................")
print(obj.get(1))
obj.deleteAtIndex(1)
print(obj.get(1))
