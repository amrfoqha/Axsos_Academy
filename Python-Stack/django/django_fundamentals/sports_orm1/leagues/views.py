from django.shortcuts import render, redirect
from .models import *

from . import team_maker

def index(request):
	context = {
		"leagues_baseball": get_baseball_leagues(),
		"leagues_women": get_womens_leagues(),
		"leagues_hockey": get_hockey_leagues(),
        "leagues_sports": get_leagues_exclude_football(),
        "leagues_conference": get_leagues_conference(),
        "leagues_in_Atlantic": get_leagues_in_Atlantic(),
        "Teams_in_Dallas": get_Teams_in_Dallas(),
        "Teams_name_Raptors": get_Teams_name_Raptors(),
        "Teams_location_city": get_Teams_location_City(),
        "Teams_name_startwith": get_Teams_name_startwith(),
        "get_all_Teams_order": get_all_Teams_order(),
        "get_all_Teams_Reverse_order": get_all_Teams_Reverse_order(),
        "get_players_lastname": get_players_lastname(),
        "get_players_firstname": get_players_firstname(),
        "get_players_lastname_except": get_players_lastname_except(),
        "get_players_lastname_with_firstname": get_players_lastname_with_firstname(),
  
		"teams": Team.objects.all(),
		"players": Player.objects.all(),
	}
	return render(request, "leagues/index.html", context)

def make_data(request):
	team_maker.gen_leagues(10)
	team_maker.gen_teams(50)
	team_maker.gen_players(200)

	return redirect("index")