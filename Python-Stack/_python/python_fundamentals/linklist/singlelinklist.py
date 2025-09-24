from node import Node

class SLL:
    def __init__(self):
        self.head=None
    def insert_node(self,num,char):
        newnode=Node(num,char)
        if(not self.head):
            self.head=newnode
            return self
        current=self.head
        while(current.next):
            current=current.next
        current.next=newnode
        return self
    
    def display_list(self):
        if(not self.head):
            print("the link list is empty")
            return self
        current=self.head
        while(current):
            print(f"[{current.num},{current.char}]")
            current=current.next
        return self
    
    def search_previous_node(self,num):
        if(not self.head):
            print("the linklist is empty")
            return self
        if(self.head.num==num):
            return self.head
        
        current=self.head
        while (current.next):
            if(current.next.num==num):
                return current#its return the previous node for the node that have a num as a data
            current=current.next
        print(f"there's no node contain this num {num}")    
        return self
    

    def delete_node(self,num):

        current=self.search_previous_node(num)
        print("....",current)
        current.next=current.next.next
        return self



    

linklist=SLL()
linklist.insert_node(1,'a').insert_node(2,'b').insert_node(3,'c').insert_node(4,'d').insert_node(5,'e').insert_node(6,'t').display_list()

print(linklist.search_previous_node(6))
linklist.delete_node(3).display_list()
               
        