from django.db import models

# Create your models here.
class Dojos(models.Model):
    name=models.CharField(max_length=20)
    city=models.CharField(max_length=20)
    state=models.CharField(max_length=20)
    desc=models.CharField(max_length=40,default='amrfoqha signature')
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    
class Ninjas(models.Model):
    first_name=models.CharField(max_length=20)
    last_name=models.CharField(max_length=20)
    dojo=models.ForeignKey(Dojos,related_name='ninjas',on_delete=models.CASCADE)
    
    
def get_all_Dojos():
    return Dojos.objects.all()    

def get_Dojo(id):
    return Dojos.objects.get(id=id)    


def create_dojo(name,city,state):
    Dojos.objects.create(name=name,city=city,state=state)

def create_ninja(first_name,last_name,dojo):
    Ninjas.objects.create(first_name=first_name,last_name=last_name,dojo=dojo)
    
def delll():
    for i in range(12,23):
        user=Dojos.objects.get(id=i)
        user.delete()

def delete_Dojo(id):
    dojo1=Dojos.objects.get(id=id)
    dojo1.delete()        

       