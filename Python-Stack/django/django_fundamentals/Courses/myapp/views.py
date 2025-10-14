from django.shortcuts import render,redirect
from .models import *


# Create your views here.

def root(request):
    context={'courses':get_courses()}
    print('in views root')
    return render(request,'main.html',context)
def add_course(request):
    if request.method=="POST":
        if  create_course(request):
            
            return redirect('/')
        else :
            return redirect('/')
    else :
        return redirect('/')

def remove(request,id):
    context={
        'course':get_course(id)
    }
    return render(request,'confirm.html',context)

def approved(request,id):
    delete_course(id)
    return redirect('/add_course')

def comments(request,id):
    
    context={
        'course':get_course(id)
    }
    return render(request,'comment.html',context)
    
def add_comments(request):
    id=request.POST['hidden']
    com=request.POST['comment']
    comment=create_comment(com)
    link_comment_with_course(comment,id)
    return redirect(f'/comment/{id}')
    