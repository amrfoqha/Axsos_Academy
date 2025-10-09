from django.db import models
from django.db.models import Q

class League(models.Model):
	name = models.CharField(max_length=50)
	sport = models.CharField(max_length=15)
	created_at = models.DateTimeField(auto_now_add=True)
	updated_at = models.DateTimeField(auto_now=True)

class Team(models.Model):
	location = models.CharField(max_length=50)
	team_name = models.CharField(max_length=50)
	league = models.ForeignKey(League, related_name="teams", on_delete = models.CASCADE)

class Player(models.Model):
	first_name = models.CharField(max_length=15)
	last_name = models.CharField(max_length=15)
	curr_team = models.ForeignKey(Team, related_name="curr_players", on_delete = models.CASCADE)
	all_teams = models.ManyToManyField(Team, related_name="all_players")


def get_baseball_leagues():
	return League.objects.filter(sport__exact="Baseball")

def get_womens_leagues():
	return League.objects.filter( name__contains="women")

def get_hockey_leagues():
    return League.objects.filter( sport__contains="Hockey")

def get_leagues_exclude_football():
    return League.objects.exclude( sport__contains="football")
    
def get_leagues_conference():
    return League.objects.filter( name__contains="conf")


def get_leagues_in_Atlantic():
    return    League.objects.filter(name__contains="Atlantic")

def get_Teams_in_Dallas():
    return    Team.objects.filter(location__contains="Dallas")
def get_Teams_name_Raptors():
    return    Team.objects.filter(team_name__contains="Raptors")


def get_Teams_location_City():
    return    Team.objects.filter(location__contains="city")


def get_Teams_name_startwith():
    return    Team.objects.filter(team_name__startswith="T")

def get_all_Teams_order():
    return    Team.objects.order_by('location')

def get_all_Teams_Reverse_order():
    return    Team.objects.order_by('-location')

def get_players_lastname():
    return    Player.objects.filter(last_name__contains="Cooper")
def get_players_firstname():
    return    Player.objects.filter(first_name__contains="Joshua")

def get_players_lastname_except():
    return    Player.objects.filter(last_name__contains="Cooper").exclude(first_name__contains="Joshua")
def get_players_lastname_with_firstname():
   
	return Player.objects.filter(Q(first_name__contains="Alexander") | Q(first_name__contains="Wyatt"))

