from django.urls import path
from . import views

urlpatterns=[
    path('',views.root),
    path('/add_book',views.add_book),
    path('/show_book/<int:id>',views.show_book),
    path('/add_to_fav/<int:id>',views.add_to_fav),
    path('/unlike/<int:id>',views.remove_to_fav),
    path('/delete_book/<int:id>',views.delete_book),
    path('/update',views.book_update),
    path('/Favorites',views.Favorites),
]