from django.shortcuts import render,redirect
from .models import *

# Create your views here.
def root(request):
    if 'validation1' not in request.session:
        request.session['validation1']=True
    if 'validation2' not in request.session:
        request.session['validation2']=True    
        
    context ={
        "dojos":get_all_Dojos()
    }
    
    
    return render(request,'index.html',context)


def get_data(request):

    hidden=request.POST['hidden']
    if(hidden == "add_dojo"):
        name=request.POST['name']
        city=request.POST['city']
        state=request.POST['state']
        if(name!="" and city!="" and state!=""):
            create_dojo(name,city,state)
            request.session['validation1']=True
        else :
            request.session['validation1']=False
            print('empty fields')
             
                
        
    else : 
        first_name=request.POST['first_name']    
        last_name=request.POST['last_name']    
        dojo_id=request.POST['dojo']
        if(first_name!="" and last_name!="" and dojo_id!=""):
            create_ninja(first_name,last_name,get_Dojo(dojo_id))    
            request.session['validation2']=True
        else :
            request.session['validation2']=False
            print(request.session['validation2'])
        
           
    
    
    return redirect('/')

def toggle_vaildation(request):
    request.session['validation1']=True
    request.session['validation2']=True
    return redirect('/')

def delete_dojo(request,id):
    print(id)
    delete_Dojo(id)
    return redirect('/')
    