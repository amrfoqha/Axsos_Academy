from django.shortcuts import render,redirect
from .models import *
from myapp.models import *


# Create your views here.
def root(request):
    if(request.session['logged_in']==True):
       
        context={
            'user': get_user(request.session['user_id']),
            'messages':ge_messages(),
            # 'able_to_delete':check_time(get_created_at())
            # 'comments':get_comments(),
        }
        return render(request,'home.html',context)
    else:
        return redirect('/')

def add_message(request):
    text=request.POST['message']
    print(text)
    add_message_to_user(request.session['user_id'],create_message(text))
    return redirect('/account')

def add_comment(request):
    comment=request.POST['comment']
    message_id=request.POST['hidden']
    add_comment_to_message(message_id,create_comment(comment),request.session['user_id'])
    return redirect('/account')

# def delete_message(request,id):
#     # created_at=get_created_at(id)
#     # if check_time(created_at) :
#     delete_message_with_id(id)   
#     return redirect('/account')
def delete_message(request, id):
    if delete_message_with_id(id):
        return redirect('/account')
    else:
        return redirect('/account')
    
            
    
    