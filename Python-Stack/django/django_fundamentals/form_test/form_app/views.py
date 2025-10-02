from django.shortcuts import render,redirect

# Create your views here.
def root(request):
    return render(request,'index.html')
# def create_user(request):
#     print('Got POST info............................ ')
   
#     name_from_form=request.POST['name'] 
#     email_from_form=request.POST['email']
#     request.session['name']=name_from_form
#     request.session['email']=email_from_form
#     print(name_from_form)
#     print(email_from_form)
#     return redirect('/success')

def create_user(request):
    if request.POST['which_form']=='signup':
        request.session['fname']=request.POST['first_name']
        request.session['fname']=request.POST['last_name']
        request.session['fname']=request.POST['email']
        request.session['fname']=request.POST['password']
        return redirect('/success')
    elif request.POST['which_form']=='login':
        print('Got POST info............................ ')
        name_from_form=request.POST['name'] 
        email_from_form=request.POST['email']
        request.session['name']=name_from_form
        request.session['email']=email_from_form
        print(name_from_form)
        print(email_from_form)
        return redirect('/success')
        


def success(request):
    return render(request,'show.html')