from django.urls import path,include   
from . import views
urlpatterns = [
    path('', views.root),
    path('add_course', views.add_course),
    path('destroy/<int:id>', views.remove),
    path('approved/<int:id>', views.approved),
    path('comment/<int:id>', views.comments),
    path('add_comment', views.add_comments),
]
