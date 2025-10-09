from django.shortcuts import render,redirect
from .models import *

# Create your views here.
def root(request):
    books=get_books()
    context ={
        "books":books
    }
    return render(request,'Add_book.html',context)


def display_books(request,id):
    context={
        "book":get_book(id),
        "exclude_authors":exclude_authors(id)
    }
    return render(request,'books.html',context)

def add_book(request):
    title=request.POST['title']
    desc=request.POST['desc']
    
    create_book(title,desc)
    return redirect("/")
    

def link_authorTo_book(request):
    author_id=request.POST['authors']
    book_id=request.POST['hidden']
    link_author_book(book_id,author_id)
    return redirect(f"/books/{book_id}/")
    
def Author(request):
    authors=get_authors()
    context={
        'authors':authors
    }
    return render(request,'Add_author.html',context)

def add_author(request):
    first_name=request.POST['first_name']
    last_name=request.POST['last_name']
    notes=request.POST['notes']
    create_author(first_name,last_name,notes)
    return redirect("authors/")

def display_authors(request,id):
    
    author=get_author(id)
    context={
        "author":author,
        "exclude_books":exclude_books(id)

    }
    print(author.books.all())
    return render(request,'authors.html',context)

def link_bookTo_author(request):
    book_id=request.POST['books']
    author_id=request.POST['hidden']
    link_author_book(book_id,author_id)
    return redirect(f"/authors/{author_id}/")
    


    
        