from django.shortcuts import render,redirect
from .models import *

# Create your views here.

def root(request):
    records=Users.objects.all()
    context={'data':records}
    if 'validation' not in request.session :
        request.session['validation']='none'    
    
    return render(request,'index.html',context)

def display(request):
    
        
    first_name=request.POST['first_name']
    last_name=request.POST['last_name']
    email_address=request.POST['email']
    age=request.POST['age']
    
    if first_name and last_name and email_address and age:
        age=int(age)
        new_user=Users.objects.create(first_name=first_name,last_name=last_name,email_address=email_address,age=age)
        new_user.save()
        request.session['validation']='none'
    else :
        request.session['validation']='block'
       
            
    return redirect('/')
def hide_alert(request):
    request.session['validation']='none'
    return redirect('/')