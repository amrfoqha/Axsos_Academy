from django.db import models
import re
from django.contrib import messages
import bcrypt

# Create your models here.

class UserManager(models.Manager):
    def validation(self,request):
        errors={}
        if len(request['email'])<=0:
            errors['email']="Fill all field"
        elif not re.match(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$', request['email']): 
            errors['email1']="Email should be Valid"
        elif is_not_unique(request['email']) :
            errors['email']="email already exists"
        if len(request['password'])<8:
            errors['password']="Password must be at least 8 characters"
        if request['password']!=request['confirm_password']:
            errors['confirm_password']="Passwords must be match"        
        return errors 
    def validation_login(self,request):
        errors={}
        if len(request['email'])<=0:
            errors['email']='Email must be filled'
        elif not search_email(request['email']):
            errors['email']='Wrong email or password'
        if len(request['password'])<=0:
            errors['password']='Wrong email or password'   
        return errors    
            
      
    
class MessageManager(models.Manager):
    pass

class Users(models.Model):
    email=models.EmailField(max_length=50,unique=True)
    first_name=models.CharField(max_length=20)
    last_name=models.CharField(max_length=20)
    password=models.CharField(max_length=100)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    user_level=models.CharField(max_length=5,default='NORMAL')
    objects=UserManager()
    
class Messages(models.Model):
    message=models.TextField(max_length=200)    
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    user=models.ForeignKey(Users,related_name='messages',on_delete=models.CASCADE,null=True)
    objects=MessageManager()
    

def create_user(request):
    email=request.POST['email']
    first_name=request.POST['first_name']
    last_name=request.POST['last_name']
    password=request.POST['password']
    errors=Users.objects.validation(request.POST)
    if len(errors)>0:
        for key,val in errors.items():
            messages.error(request,val,f'reg_{key}')
        return False
    hash1=bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
    user=Users.objects.create(email=email,first_name=first_name,last_name=last_name,password=hash1)
    request.session['logged_in']=True
    request.session['user_id']=user.id  
    # if check_if_first_user(user.id):
    change_to_admin(user.id)
    return True    
def create_new_user(request):
    email=request.POST['email']
    first_name=request.POST['first_name']
    last_name=request.POST['last_name']
    password=request.POST['password']
    errors=Users.objects.validation(request.POST)
    if len(errors)>0:
        for key,val in errors.items():
            messages.error(request,val,f'reg_{key}')
        return False
    hash1=bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
    user=Users.objects.create(email=email,first_name=first_name,last_name=last_name,password=hash1)
    return True    
 
def login_user(request):
    email=request.POST['email']
    password=request.POST['password']
    errors=Users.objects.validation_login(request.POST)
    if len(errors)>0:
        for key,val in errors.item():
            messages.error(request,val,f'log_{key}')
        return False
    user=search_email(email)
    if bcrypt.checkpw(password.encode(),user.password.encode()):
        request.session['logged_in']=True
        request.session['user_id']=user.id 
        return True
    else: 
        messages.error(request,'Wrong password or email','log_password')
        return False
            
             
    
            
     

def search_email(email):
    return Users.objects.filter(email__exact=email)[0]

def is_not_unique(email):
    return Users.objects.filter(email__exact=email).exists()    

# def check_if_first_user(id):
#     if id==1:
#         return True
#     return False
def change_to_admin(id):
    user=Users.objects.first()
    if user.id == id :
        user.user_level="ADMIN"
        user.save()
    else: 
        return    

def get_user(id):
    return Users.objects.get(id=id)    
def get_users():
    return Users.objects.all()
    
    