from django.urls import path
from . import views

urlpatterns =[
    path('',views.root),
    path('gold',views.gold),
    path('farm',views.farm),
    path('cave',views.cave),
    path('house',views.house),
    path('quest',views.quest),
]