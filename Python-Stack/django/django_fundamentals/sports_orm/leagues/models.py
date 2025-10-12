from django.db import models
from django.db.models import Count

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


def query1():
	return Team.objects.filter(league__name__contains="Atlantic")
def query2():
	return Player.objects.filter(curr_team__team_name__contains="Boston Penguins")
def query3():
	return Player.objects.filter(curr_team__league__name__iexact="International Collegiate Baseball Conference")
def query4():
	return Player.objects.filter(curr_team__league__name__iexact="American Conference of Amateur Football").filter(last_name__contains="Lopez")
def query5():
	return Player.objects.all()
def query6():
	return Team.objects.filter(curr_players__first_name__contains="Sophia")
def query7():
	return League.objects.filter(teams__curr_players__first_name__contains="Sophia")
def query8():
	return Player.objects.exclude(curr_team__team_name__contains="Rough")
def query9():
	player=Player.objects.filter(first_name="Samuel")
	return Team.objects.filter(all_players__in=player)
def query10():
	team=Team.objects.filter(team_name="Tiger-Cats",location="Manitoba")
	return Player.objects.filter(all_teams__in=team)
def query11():
	team=Team.objects.filter(team_name="Vikings",location="Wichita")
	return Player.objects.filter(all_teams__in=team).exclude(curr_team__in=team)
def query12():
	players=Player.objects.filter(first_name__contains="Jacob",last_name="Gray")
	return Team.objects.filter(all_players__in=players).exclude(curr_players__in=players)
def query13():
    teams=Team.objects.filter(league__name__icontains="atlantic Federation")
    return Player.objects.filter(all_teams__in=teams).filter(first_name__iexact="Joshua")
def query14():
    return Team.objects.annotate(num_players=Count('all_players')).filter(num_players__gte=12)
def query15():
    return Player.objects.annotate(count_of_teams=Count('all_teams')).order_by('count_of_teams')
    
