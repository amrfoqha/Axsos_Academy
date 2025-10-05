from django.shortcuts import render,redirect

# Create your views here.

def root(request):
    
    return redirect('/display')

def destroy(request):
    request.session['counter']=0
    return redirect('/display')

def incrementby2(request):
    
    if('counter' not in request.session):
        request.session['counter']=0
        
    request.session['counter']+=int(request.POST['range'])
    return redirect('/display')

def display(request):
    if('counter' in request.session):
        request.session['counter']+=1
    else:     
        request.session['counter']=1
    return render(request,'index.html')    
