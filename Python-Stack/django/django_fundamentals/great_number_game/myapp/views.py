from django.shortcuts import render , redirect
import random

# Create your views here.

def root(request):
    request.session['rand']=random.randint(1,100)
    
    return redirect('/toggle')

def toggel(request):
    request.session['correct']=False
    request.session['toggle']=False
    return render(request,'index.html')
def guessing(request):
    correct=False
    request.session['toggle']=True
    
    request.session['value']=int(request.POST['number'])
    if request.session['value'] > request.session['rand']:
        message='To High!'
    elif request.session['value'] < request.session['rand']:
        message='To Low!'     
    else :
        message=f"{request.session['value']} was the number!"
        request.session['correct']=True
            
    context = {
        'message':message,
        'correct':request.session['correct']
    }    
    request.session['toggle']=True
    return render(request,'index.html',context)

def tryagain(request):
    return redirect('/')