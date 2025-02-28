"""from django.urls import path
from django.http import JsonResponse
from otree.urls import urlpatterns as otree_urlpatterns
import os

def run_shell_script(request):
    script_path = "./script.sh"
    
    if not os.path.exists(script_path):
        return JsonResponse({"message": f"Error: Script not found at {script_path}"})
    
    os.system(f"bash {script_path}")
    return JsonResponse({"message": "Script executed successfully!"})

urlpatterns = [
    path('otree/', include(otree_urlpatterns)),
    path("run_script/", run_shell_script, name="run_script"),
]"""