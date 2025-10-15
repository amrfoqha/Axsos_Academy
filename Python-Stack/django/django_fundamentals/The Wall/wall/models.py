from django.db import models
from django.db import models
import re
from myapp.models import *
from datetime import timedelta,datetime
from django.utils import timezone

# Create your models here.

# class CommentsManager(models.Manager):
#     def basic_validator(self, postData,):
#         errors={}
#         if(len(postData['first_name'])<2):
#             errors['first_name']="first name should be at least 2 characters"
#         if len(postData['last_name'])<2:
#             errors['last_name']="last name should be at least 2 characters"
#         if len(postData['email'])<=0:
#             errors['email']="Email should be filled"
#         elif not re.match(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$', postData['email']): 
#             errors['email1']="Email should be Valid"
#         elif if_email_not_unique(postData['email']):
#             errors['email2']="email already exists"
#         if len(postData['password'])<8 :
#             errors['password']="Password should be at least 8 characters"
#         if postData['password']!=postData['confirm_pw']  :
#             errors['confirm_password']="Passwords should be match"
                

#         return errors
                






class Messages(models.Model):
    message=models.TextField(max_length=350)
    user=models.ForeignKey(Users,related_name='messages',on_delete=models.CASCADE,null=True)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    # deletable=models.BooleanField(default=False)
    
class Comments(models.Model):
    comment=models.TextField(max_length=350)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    user=models.ForeignKey(Users,related_name='comments',on_delete=models.CASCADE,null=True)
    message=models.ForeignKey(Messages,related_name='comments',on_delete=models.CASCADE,null=True)
    

def create_message(text):
    return Messages.objects.create(message=text)
def create_comment(text):
    return Comments.objects.create(comment=text)

def add_message_to_user(user_id,message):
    user=Users.objects.get(id=user_id)
    user.messages.add(message)  
    
def add_comment_to_message(message_id,comment,user_id):
    message=Messages.objects.get(id=message_id)
    user=Users.objects.get(id=user_id)
    user.comments.add(comment)  
    
    message.comments.add(comment)  
def ge_messages():
    return Messages.objects.order_by('-created_at')
def delete_message_with_id(id):
    msg=Messages.objects.get(id=id)
    msg.delete()
    print('deleted')
            
# def check_time(created_at):
#     x=timezone.now()
#     if created_at+timedelta(hours=3,minutes=30) <= x: 
#         print('can delete')
#         return True
#     print('cannot delete')
#     return False      
# def get_created_at(id):
#     message=Messages.objects.get(id=id)
#     return message.created_at

def delete_message_with_id(message_id):

    message = Messages.objects.get(id=message_id)
    now = timezone.now()
    if now - message.created_at <= timedelta(minutes=30):
        message.delete()
        return True  
    else:
        return False  

    return False  