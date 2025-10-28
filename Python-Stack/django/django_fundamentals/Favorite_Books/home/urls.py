from django.conf import settings
from django.conf.urls.static import static
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
    path('/view_test',views.view_test),
    path('/add_img',views.add_img),
]



if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)