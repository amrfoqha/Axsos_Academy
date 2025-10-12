from django.shortcuts import render,redirect
from .models import *
from django.contrib import messages
# Create your views here.

def index(request):
    context={
        "shows":get_all_show()
    }
    return render(request,'display_shows.html',context)

def add_show(request):
    # return redirect('add_new_show')
    return render(request,'add_shows.html')

def add_new_show(request):
    title=request.POST['title']
    network=request.POST['network']
    release_date=request.POST['release_date']
    desc=request.POST['desc']
    errors=Shows.objects.basic_validator(request.POST)
    if len(errors)>0:
        if check_title_unique(title):
            messages.error(request, "Title already exists")
        for key,value in errors.items():
            messages.error(request,value)
        return redirect('/add_show')
    else:    
        new_show=add_a_show(title,network,release_date,desc)
        id=new_show.id
        messages.success(request,'show successfully created')
        return redirect(f'shows/{id}')

def display_show(request,id):
    show=get_a_show(id)
    context={
        'show':show
    }
    return render(request,'show.html',context)
def show_edit(request,id):
    context={
        'id':id
    }   
    return render(request,'edit_shows.html',context)

def show_update(request):
    id=request.POST['hidden']
    title=request.POST['title']
    network=request.POST['network']
    release_date=request.POST['release_date']
    desc=request.POST['desc']
    errors=Shows.objects.basic_validator(request.POST)
    if len(errors)>0:
        if check_title_unique_to_update(title,id):
            messages.error(request, "Title already exists",extra_tags="update_title")
        for key,value in errors.items():
            messages.error(request,value,extra_tags=f"update_{key}")
        return redirect(f'show_edit/{id}')
    else:    
        update_a_show(id,title,network,release_date,desc)
        messages.success(request,'show successfully updated')
    return redirect(f'shows/{id}')   
def delete_show(request,id):
    delete_a_show(int(id))
    return redirect('/')
