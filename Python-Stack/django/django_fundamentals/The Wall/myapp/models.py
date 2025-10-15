from django.db import models
import re
from wall.models import *
# Create your models here.

class UserManager(models.Manager):
    def basic_validator(self, postData,str):
        errors={}
        if str=='reg':
            if(len(postData['first_name'])<2):
                errors['first_name']="first name should be at least 2 characters"
            if len(postData['last_name'])<2:
                errors['last_name']="last name should be at least 2 characters"

            if len(postData['email'])<=0:
                errors['email']="Email should be filled"
            elif not re.match(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$', postData['email']):
                errors['email1']="Email should be Valid"
            elif if_email_not_unique(postData['email']):
                errors['email2']="email already exists"
            if len(postData['password'])<8 :
                errors['password']="Password should be at least 8 characters"
            if postData['password']!=postData['confirm_pw']  :
                errors['confirm_password']="Passwords should be match"
                
        else:
            if not re.match(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$', postData['email']):
                errors['email']="Email should be Valid"
            elif not search_user(postData['email']):    
                errors['login']="Email provided not found"    
            if len(postData['password'])<8 :
                errors['password']="Password should be at least 8 characters"
            if len(postData['password'])<=0 :
                errors['password']="Please Enter Password"
            
            
                
        return errors
                
        



class Users(models.Model):
    first_name=models.CharField(max_length=20)
    last_name=models.CharField(max_length=20)
    email=models.CharField(max_length=50,unique=True)
    password=models.CharField(max_length=100)
    objects=UserManager()
    created_at=models.DateTimeField(auto_now=True)
    updated_at=models.DateTimeField(auto_now_add=True)
    
    
    
    
def create_user(first_name,last_name,email,password):
    return Users.objects.create(first_name=first_name,last_name=last_name,email=email,password=password)
 
def search_user(email):
    return Users.objects.filter(email__exact=email)[0]
            
def if_email_not_unique(email):
    return Users.objects.filter(email__exact=email).exists()          

def get_user(id):
    return Users.objects.get(id=id)