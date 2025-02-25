from otree.api import *
import os
import time

"""class Instructions(Page):
    Introduction and instructions before the task
    timeout_seconds = 120  # Set a time limit for reading instructions (optional)"""

class Task(Page):
    """The main developer task with a split-screen setup"""
    timeout_seconds = 1200
    template_name = 'chatGPT/templates/Task.html'
    

    """def js_vars(player):
        return {"start_time": int(time.time() * 1000)}"""

class Break(Page):
    """Break screen before post-task questions"""
    timeout_seconds = 60  # 1-minute break
    template_name = 'chatGPT/templates/Break.html'

class Survey(Page):
    """Post-task questionnaire"""
    form_model = 'player'
    form_fields = ['feedback']
    template_name = 'chatGPT/templates/Survey.html'

page_sequence = [Task, Break, Survey]