from django.db import models
from django.db.models import Sum

class Product(models.Model):
    description = models.CharField(max_length=45)
    price = models.DecimalField(decimal_places=2, max_digits=5)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Order(models.Model):
    quantity_ordered = models.IntegerField()
    total_price = models.DecimalField(decimal_places=2, max_digits=6)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    
    
def get_the_recent_order():
    return Order.objects.order_by('created_at').first()    
def count_all_orders():
    x=Order.objects.aggregate(total_orders=Sum(('quantity_ordered')))
    return x['total_orders']
def charged_for_all_orders():
    x=Order.objects.aggregate(total_price=Sum(('total_price')))
    return x['total_price']