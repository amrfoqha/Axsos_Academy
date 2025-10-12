from django.db import models
from datetime import datetime,date


# Create your models here.
class ShowsManager(models.Manager):
    def basic_validator(self,postdata):
        errors={}
        release_date=datetime.now()
        if len(postdata['title'])<=2:
            errors['title']="Title should be at least 2 characters"
        
            
        if len(postdata['network'])<=3:
            errors['network']="network should be at least 3 characters"
        if len(postdata['desc'])>0 and len(postdata['desc'])<10:
            errors['description']="description should be at least 10 characters"
            
        release_date_str = postdata.get('release_date')
        if not release_date_str:
            errors['release_date'] = "Release date is required"
        else:
            release_date = datetime.strptime(release_date_str, "%Y-%m-%d").date()
            if release_date >= date.today():
                errors['release_date'] = "Release date should be in the past"
           
               

        return errors   
            
               
            
            
                          
class Shows(models.Model):
    title = models.CharField(max_length=100)
    network = models.CharField(max_length=100)
    release_date = models.DateField()
    description = models.TextField(default=" ")
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    objects=ShowsManager()


def add_a_show(title, network, release_date, description):
    return    Shows.objects.create(title=title, network=network, release_date=release_date, description=description)
    


def update_a_show(id, title, network, release_date, description):
    update = Shows.objects.get(id=id)
    update.title = title
    update.network = network
    update.release_date = release_date
    update.description = description
    update.save()

def delete_a_show(id):
    Shows.objects.get(id=id).delete()
def get_a_show(id):
    return Shows.objects.get(id=id)
def get_all_show():
    return Shows.objects.all()
def check_title_unique(title):
    return Shows.objects.filter(title__iexact=title).exists()
def check_title_unique_to_update(title,newid):
    return Shows.objects.filter(title__iexact=title).exclude(id=newid).exists()

    