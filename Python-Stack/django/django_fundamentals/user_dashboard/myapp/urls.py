from django.urls import path
from . import views

urlpatterns=[
    path('',views.root),
    path('display_login',views.display_login),
    path('Sign_up',views.display_sign_up),
    path('login',views.login),
    path('registration',views.registration),
    path('dashboard',views.display_dashboard),
    path('logout',views.logout),
    path('add_user',views.add_user),
    path('user_profile/<int:id>',views.display_profile),
    path('edit/<int:id>',views.edit_user),
    path('remove/<int:id>',views.remove_user),
    path('add_new_user',views.add_new_user),
    path('change_password/<int:id>',views.change_password),
]