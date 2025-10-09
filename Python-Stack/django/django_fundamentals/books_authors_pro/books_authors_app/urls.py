from django.urls import path
from . import views

urlpatterns = [
    path('', views.root),
    path('add_book', views.add_book),
    path('books/<int:id>', views.display_books),
    path('link_authorTo_book', views.link_authorTo_book),
    path('authors/', views.Author),
    path('add_author', views.add_author),
    path('authors/<int:id>', views.display_authors),
    path('link_bookTo_author', views.link_bookTo_author),
]
