from django.shortcuts import render,redirect
from .models import *

def index(request):
    context = {
        "all_products": Product.objects.all(),
    }
    return render(request, "store/index.html", context)

def checkout(request):
    if request.method=="POST":
        request.session['quantity_from_form'] = int(request.POST["quantity"])
        request.session['price_from_form'] = request.POST["product"]
        request.session['total_charge'] = request.session['quantity_from_form'] * request.session['price_from_form']
        print("Charging credit card...")
        Order.objects.create(quantity_ordered=request.session['quantity_from_form'], total_price=request.session['total_charge'])
        
        return redirect("/render_checkout")
    else:
        return redirect('/')
    
def display_checkout(request):
    context={
            'price':request.session['price_from_form'],
            'ordered':request.session['quantity_from_form'],
            'total':request.session['total_charge'],
            'first_recent':get_the_recent_order(),
            'total_quantity_of_all_orders':count_all_orders(),
            'charged_for_all_orders':charged_for_all_orders(),
        }
    return render(request,'store/checkout.html',context)    