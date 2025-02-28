from otree.api import *
import requests, os, time

class Instructions(Page):
    timeout_seconds = 5*60
    template_name = 'chatGPT/templates/Instructions.html'

class TaskDescription1(Page):
    timeout_seconds = 3*60
    template_name = 'chatGPT/templates/TaskDescription1.html'

    @staticmethod
    def vars_for_template(player):
        return dict(
            useAI = False,
        )

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/setup-exp1')

class Task1(Page):
    """The main developer task with a split-screen setup"""
    timeout_seconds = 20*60
    template_name = 'chatGPT/templates/Task.html'
    
    @staticmethod
    def vars_for_template(player):
        return dict(
            useAI = False,
        )

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/takedown-exp1')

class Break1(Page):
    """Break screen before task description"""
    timeout_seconds = 2*60 
    template_name = 'chatGPT/templates/Break.html'

class Break2(Page):
    """Break screen before task description"""
    timeout_seconds = 2*60
    template_name = 'chatGPT/templates/Break.html'

class Survey(Page):
    """Post-task questionnaire"""
    form_model = 'player'
    form_fields = ['feedback']
    template_name = 'chatGPT/templates/Survey.html'

page_sequence = [Instructions, Break1, TaskDescription1, Task1, Break2, Survey]