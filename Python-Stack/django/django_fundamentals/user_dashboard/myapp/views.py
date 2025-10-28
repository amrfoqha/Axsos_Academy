from django.shortcuts import render,redirect
from .models import *


# Create your views here.
def root(request):
    if 'logged_in' not in request.session:
        request.session['logged_in']=False
    if 'user_id' not in request.session:
        request.session['user_id']=None    
    return render(request,'main.html')

def display_login(request):
    return render(request,'login.html')

def login(request):
    if login_user(request):
        return redirect('/dashboard')
    else:
        return redirect('/Sign_up')

def display_sign_up(request):
    
    return render(request,'sign_up.html')

def registration(request):
    
    if create_user(request):
        return redirect('/display_login')
    else:
        return redirect('/Sign_up')

def logout(request):
    del request.session['logged_in']
    del request.session['user_id']
    return redirect('/')
            
def display_dashboard(request):
    if request.session['logged_in']:
        context={
            'client':get_user(request.session['user_id']),
            'users':get_users()
        }

        return render(request,'dashboard.html',context)            
    else :
        return redirect('/')
    
def add_user(request):
    if request.session['logged_in']:
        user=get_user(request.session['user_id'])
        if user.user_level=="ADMIN":
           return render(request,'add_user.html')
        else:            
           return redirect('/dashboard')
            
    else :
        return redirect('/')

def add_new_user(request):
    if request.session['logged_in']:
        user=get_user(request.session['user_id'])
        if user.user_level=="ADMIN":
            if create_new_user(request):
                return redirect('/dashboard')
            else:
                return redirect('/add_user')
        else:            
           return redirect('/dashboard')
            
    else :
        return redirect('/') 
        
def display_profile(request,id):
    context={
        'client':get_user(id)
    }
    return render(request,'profile.html',context)
    
def edit_user(request,id):
    pass
def remove_user(request,id):
    pass
def change_password(request,id):
    pass
         
