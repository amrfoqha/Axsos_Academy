from django.shortcuts import render, HttpResponse,redirect,HttpResponseRedirect
from django.http import JsonResponse

def index(request):
    return HttpResponse("this is the equivalent of @app.route('/')!")

def root(request):
    print('dasdasdasdasdasdaasdas')
    return HttpResponseRedirect('/blogs')

def index(request):
    return HttpResponse("placeholder to later display a list of all blogs")

def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")

def create(request):
    return redirect('/')

def show(request,number):
    return HttpResponse(f"placeholder to display blog number: {number}" )

def edit(request,number):
    return HttpResponse(f"placeholder to edit blog number: {number}" )
def destroy(request,number):
    return HttpResponseRedirect('/blogs')
def result(request):
    data={
        "title" : "my first blog",
    "content" : "lorem, ipsum dolor sit amet consectetur adipisicing elit."
           }
    
    return JsonResponse(data)
