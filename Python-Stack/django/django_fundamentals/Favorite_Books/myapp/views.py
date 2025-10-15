import bcrypt
from django.shortcuts import render,redirect
from .models import *
from django.contrib import messages
from home.templates import *

# Create your views here.
def root(request):
                
    if "user" not in request.session:
        request.session['user_id']=None
    if "logged_in" not in request.session:
        request.session['logged_in']=False
            
    return render(request,'login.html')

def check(request):
    type=request.POST['hidden']
    if type=="registration":
        first_name=request.POST['first_name']
        last_name=request.POST['last_name']
        email=request.POST['email']
        password=request.POST['password']
        errors=Users.objects.basic_validator(request.POST,'reg')
        if len(errors)>0:
            for key,val in errors.items():
                messages.error(request,val,'reg_{key}')
            return redirect('/')  
        else:  
            hash1 = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
            
            user=create_user(first_name,last_name,email,hash1)
            request.session['user_id']=user.id
            request.session['logged_in']=True
            return redirect('/home')
            
    else:
        errors=Users.objects.basic_validator(request.POST,'log')
        if len(errors)>0:
            for key,val in errors.items():
                messages.error(request,val,'log_{key}')
            return redirect('/')  
        else:
            email=request.POST['email']
            password=request.POST['password']
            user=search_user(email)
            if bcrypt.checkpw(request.POST['password'].encode(), user.password.encode()):
                request.session['logged_in']=True
                request.session['user_id']=user.id
                return redirect('/home')
            else:
                messages.error(request,"Wrong password",'log_pass')
                return redirect('/') 
            
# def display_success(request):
#     if(request.session['logged_in']==True):
       
#         context={
#             'user': get_user(request.session['user_id'])
#         }
#         return render(request,'home.html',context)
#     else:
#         return redirect('/')
    
def flush_session(request):
    del request.session['logged_in']
    del request.session['user_id']
    return redirect('/')
    

                        
            
                
      
