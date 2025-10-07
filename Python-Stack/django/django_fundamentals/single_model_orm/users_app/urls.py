from django.urls import path
from . import views

urlpatterns=[
    path('',views.root),
    path('display',views.display),
    path('hide_alert',views.hide_alert),
]
