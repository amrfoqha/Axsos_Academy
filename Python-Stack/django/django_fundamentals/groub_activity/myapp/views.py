from django.shortcuts import render
from .models import *


def root(request):
    context={"records": getallusers()}
    return render(request,'index.html',context)
    
# Create your views here.
