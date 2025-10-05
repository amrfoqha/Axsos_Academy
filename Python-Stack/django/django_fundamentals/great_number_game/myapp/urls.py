from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('toggle',views.toggel),
    path('guessing',views.guessing),
    path('tryagain',views.tryagain),
]