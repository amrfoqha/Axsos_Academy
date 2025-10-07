from django.urls import path
from . import views

urlpatterns=[
    path('',views.root),
    path('getdata',views.get_data),
    path('delete_dojo/<str:id>/',views.delete_dojo),
    path('flush',views.toggle_vaildation),
]