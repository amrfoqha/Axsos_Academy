from django.shortcuts import render,redirect
from myapp.models import *
from .models import *
from django.contrib import messages

# Create your views here.
def root(request):
    if(request.session['logged_in']==True):
       
        context={
            'user': get_user(request.session['user_id']),
            'books':get_books()
        }
        return render(request,'home.html',context)
    else:
        return redirect('/')
    
    
def add_book(request):
    title=request.POST['title']
    desc=request.POST['desc']
    errors=Books.object.validator(request.POST)
    if len(errors)>0:
        for key,val in errors.items():
            messages.error(request,val,'addBook_{key}')
        return redirect('/home')
    else:
        create_book(title,desc,request.session['user_id'])    
        return redirect('/home')
    
def show_book(request,id):
    if(request.session['logged_in']==True):
       
        context={
            'user': get_user(request.session['user_id']),
            'book':get_book(id)
        }
        return render(request,'book.html',context)
    else:
        return redirect('/')
    
def add_to_fav(request,id):
       add_fav(get_book(id),request.session['user_id'])
       return redirect(f'/home/show_book/{id}') 
        
def remove_to_fav(request,id):
       remove_fav(get_book(id),request.session['user_id'])
       return redirect(f'/home/show_book/{id}') 
   
def delete_book(request,id):
    remove_book(id)   
    return redirect('/home')

def book_update(request):
    book_id=request.POST['hidden']
    newtitle=request.POST['newtitle']
    newdesc=request.POST['newdesc']
    errors=Books.object.validator(request.POST)
    if len(errors)>0:
        for key,val in errors.items():
            messages.error(request,val,'addBook_{key}')
        return redirect('/show_book/<int:id>')
    else:
        update_book(newtitle,newdesc,book_id)    
        return redirect(f'/show_book/{book_id}')
        
def Favorites(request):
    if(request.session['logged_in']==True):
       
        context={
            'user': get_user(request.session['user_id']),
            'fav_books':get_fav_books(request.session['user_id'])
        }
        
        return render(request,'favBook.html',context)
    else:
        return redirect('/')
   
    
        
    
        