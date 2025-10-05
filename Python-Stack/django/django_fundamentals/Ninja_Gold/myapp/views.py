from django.shortcuts import render,redirect
import random,math

from datetime import datetime

# Create your views here.
def root(request):
    request.session['context'] = []
    request.session['total']=0
    request.session['text'] = ''
    return render(request,'index.html')

def gold(request):
    if 'context' not in request.session:
        request.session['context'] = []
    randval=0
 
    time=datetime.now( )
    formatted_time = time.strftime("%Y-%m-%d %H:%M:%S")
    hidden = request.POST['hidden']
    if hidden !='Quest':
        if 'total' in request.session :
            randval=random.randint(10,20)
            request.session['total']=request.session['total'] + randval
            request.session['context'].insert(0,{"color":"green",
            "message":f"You entered a {hidden} and earned {randval} gold! ({formatted_time}) \n"})
            
        else :
            request.session['total']=0
        if hidden =='farm':
            return redirect('/farm')    
        if hidden =='Cave':
            return redirect('/cave')    
        if hidden =='House':
            return redirect('/house')    
    else :
        
        randval=random.randint(-50,50)
        request.session['total']=request.session['total'] + randval
        if randval <= 0:
            request.session['context'].insert(0,{"color":"red",
            "message":f"You failed a {hidden} and lost {abs(randval)} gold! Ouch. ({formatted_time}) \n"})
        
        else :  
            request.session['context'].insert(0,{"color":"green",
            "message":f"You entered a {hidden} and earned {abs(randval)} gold! ({formatted_time}) \n"})
        
        return redirect('/quest')    
    
    
    
        
    

def farm(request):
    return render(request,"index.html")
def cave(request):
    return render(request,"index.html")
def house(request):
    return render(request,"index.html")
def quest(request):
    return render(request,"index.html")
        
    