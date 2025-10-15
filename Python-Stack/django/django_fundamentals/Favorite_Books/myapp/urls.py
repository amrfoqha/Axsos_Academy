from django.urls import path
from . import views

urlpatterns=[
    path('',views.root),
    path('check_succession',views.check),
    # path('display_success',views.display_success),
    path('flush_session',views.flush_session),
]