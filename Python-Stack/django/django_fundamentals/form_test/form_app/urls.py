from django.urls import path
from . import views

urlpatterns=[
    path('',views.root),
    path('users',views.create_user),
    path('success',views.success),
    
]