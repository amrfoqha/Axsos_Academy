from django.shortcuts import render, redirect
from .models import *

from . import team_maker

def index(request):
	context = {
		"query1": query1(),
		"query2": query2(),
		"query3": query3(), 
		"query4": query4(), 
		"query5": query5(), 
		"query6": query6(), 
		"query7": query7(), 
		"query8": query8(), 
		"query9": query9(), 
		"query10": query10(), 
		"query11": query11(), 
		"query12": query12(), 
		"query13": query13(), 
		"query14": query14(), 
		"query15": query15(), 
		"teams": Team.objects.all(),
		"players": Player.objects.all(),
	}
	return render(request, "leagues/index.html", context)

def make_data(request):
	team_maker.gen_leagues(10)
	team_maker.gen_teams(50)
	team_maker.gen_players(200)

	return redirect("index")