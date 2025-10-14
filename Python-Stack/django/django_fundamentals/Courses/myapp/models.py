from django.db import models
from django.contrib import messages

# Create your models here.
class CourseManager(models.Manager):
    def add_validator(self,requestdata):
        errors={}
        if len(requestdata['name'])<=5:
            errors['name']='name must be more than 5 characters'
        if len(requestdata['desc'])<=15:
            errors['desc']='description must be more than 15 characters'
        return errors    
        
    
class Descriptions(models.Model):
    description=models.CharField(max_length=150)


class Courses(models.Model):
    name=models.CharField(max_length=20)
    description=models.OneToOneField(Descriptions,related_name='course',on_delete=models.CASCADE)
    
    created_at=models.DateTimeField(auto_now=True)
    updated_at=models.DateTimeField(auto_now_add=True)
    objects=CourseManager()
class Comments(models.Model):
    comment=models.CharField(max_length=150)    
    course=models.ForeignKey(Courses,related_name='comments',on_delete=models.CASCADE,null=True)
    
    
        
def create_course(request):
    name=request.POST['name']
    desc=request.POST['desc']
    errors=Courses.objects.add_validator(request.POST)
    if len(errors)>0:
        for key,val in errors.items():
            messages.error(request,val)
        return False
    else :
        print('hhhhhhhhh')
        Courses.objects.create(name=name,description=create_description(desc))
        return True
def get_courses():
    print('helo in get course')
    return Courses.objects.all()  
    
    
    
    
def create_description(desc):
    print('in create description')
    return Descriptions.objects.create(description=desc)  


      
def get_course(id):
    return Courses.objects.get(id=id)        
def delete_course(id):
     Courses.objects.get(id=id).delete()        
        

def create_comment(comment):
    return Comments.objects.create(comment=comment)   

def link_comment_with_course(comment,id):
    course=get_course(id)
    course.comments.add(comment)    
     
         