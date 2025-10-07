from django.db import models

# Create your models here.


# class Movie(models.Model):
#     title = models.CharField(max_length=45)
#     description = models.TextField()
#     release_date = models.DateTimeField()
#     duration = models.IntegerField()
#     created_at = models.DateTimeField(auto_now_add=True)
#     updated_at = models.DateTimeField(auto_now=True)




# class Wizard(models.Model):
#     name=models.CharField(max_length=45)
#     house=models.CharField(max_length=45)
#     pet=models.CharField(max_length=45)
#     year=models.IntegerField()

class Users(models.Model):
    first_name=models.CharField(20)
    last_name=models.CharField(20)
    email_address=models.EmailField(100)
    age=models.IntegerField()
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)