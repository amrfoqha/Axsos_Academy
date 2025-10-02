from django.urls import path
from . import views

urlpatterns = [
    path('',views.root),
    path('submit',views.submit),
    path('info',views.info),
]