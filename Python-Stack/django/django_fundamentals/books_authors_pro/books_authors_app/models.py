from django.db import models

class Books(models.Model):
    title = models.CharField(max_length=255)
    desc= models.TextField(200)
    created_at= models.DateTimeField(auto_now_add=True)
    updated_at= models.DateTimeField(auto_now=True)

class Authors(models.Model):
    first_name=models.CharField(max_length=45)
    last_name=models.CharField(max_length=45)
    books=models.ManyToManyField(Books,related_name='authors')
    created_at= models.DateTimeField(auto_now_add=True)
    updated_at= models.DateTimeField(auto_now=True)
    notes=models.TextField(200)
    


def get_books():
    
    return Books.objects.all()

def get_book(id):
    return Books.objects.get(id=id)

def create_book(title,desc):
    return Books.objects.create(title=title,desc=desc)

def link_author_book(book_id,author_id):
    temp_book=get_book(book_id)
    temp_author=get_author(author_id)
    temp_book.authors.add(temp_author)
    return

def create_author(first_name,last_name,notes):
    
    return Authors.objects.create(first_name=first_name,last_name=last_name,notes=notes)

def get_authors():
    return Authors.objects.all()

def get_author(id):
    return Authors.objects.get(id=id)

def exclude_authors(book_id):
    temp_book=get_book(book_id)
    all_authors=temp_book.authors.all()
    all=Authors.objects.all()
    authors_list=[]
    for el in all:
        if el not in all_authors:
            authors_list.append(el)
    return authors_list

def exclude_books(author_id):
    temp_author=get_author(author_id)
    all_books=temp_author.books.all()
    all=Books.objects.all()
    books_list=[]
    for el in all:
        if el not in all_books:
            books_list.append(el)
    return books_list


