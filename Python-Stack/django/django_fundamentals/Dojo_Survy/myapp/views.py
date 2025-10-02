from django.shortcuts import render,redirect

# Create your views here.
def root(request):
    return render(request, 'index.html')

def submit(request):
    request.session['gender']=request.POST['gender']
    request.session['colors']=request.POST.getlist('color')
    request.session['name']=request.POST['Name']
    request.session['Dojo_Location']=request.POST['Dojo_Location']
    request.session['Favorite_language']=request.POST['Favorite_language']
    request.session['comment']=request.POST['comment']
    return redirect('/info')

def info(request):
    return render(request, 'info.html')
    