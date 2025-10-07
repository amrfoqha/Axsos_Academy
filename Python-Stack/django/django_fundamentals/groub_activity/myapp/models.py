from django.db import models

# Create your models here.
class User(models.Model):
    first_name=models.CharField(max_length=50)
    last_name=models.CharField(max_length=50)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    
    
class Address(models.Model):
    street=models.CharField(max_length=50)
    countery=models.CharField(max_length=50)
    city=models.CharField(max_length=50)
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    user=models.ForeignKey(User,related_name='addresss',on_delete=models.CASCADE)
    
def getallusers():
    return User.objects.all()    