from django.db import models
from myapp.models import *
# Create your models here.

class BookManager(models.Manager):
    def validator(self,request):
        errors={}
        
        if len(request['title'])==0:
            errors['title']='title is required'
        if len(request['desc'])<5 :
            errors['desc']='description must be at least 5 characters'   
        return errors    
    
        


class Books(models.Model):
    title=models.CharField(max_length=20)
    desc=models.TextField(max_length=200)
    created_at=models.DateTimeField(auto_now_add=True)
    Updated_at=models.DateTimeField(auto_now=True)
    uploaded_by=models.ForeignKey(Users,related_name="books_uploaded",on_delete=models.CASCADE,null=True)
    users_who_like=models.ManyToManyField(Users,related_name="liked_books",null=True)
    object=BookManager()
    
    
def create_book(title,desc,user_id):
    user=get_user(user_id)
    book=Books.object.create(title=title,desc=desc)
    user.books_uploaded.add(book)
    add_fav(book,user_id)
         
def add_fav(book,user_id):
    user=Users.objects.get(id=user_id)
    user.liked_books.add(book)
def remove_fav(book,user_id):
    user=get_user(user_id)
    user.liked_books.remove(book)

def get_books():
    return Books.object.all()    

def get_book(id):
    return Books.object.get(id=id)

def remove_book(id):
    book=get_book(id)
    book.delete()
    
def update_book(title,desc,book_id):
    book=Books.object.get(id=book_id)
    book.title=title
    book.desc=desc
    book.save()
    
def get_fav_books(id):
    user=get_user(id)
    return user.liked_books.all()
     
    
    