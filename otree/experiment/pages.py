from otree.api import *
import requests, os, time

class Instructions(Page):
    timeout_seconds = 3*60
    template_name = 'experiment/templates/Instructions.html'

class TaskDescription1(Page):
    timeout_seconds = 3*60
    template_name = 'experiment/templates/TaskDescriptionPage.html'

    @staticmethod
    def vars_for_template(player):
        return dict(
            id = 1,
            useAI = os.getenv('AI_FIRST', 'True').lower() == 'true',
        )

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/setup-exp1')

class TaskDescription2(Page):
    timeout_seconds = 3*60
    template_name = 'experiment/templates/TaskDescriptionPage.html'

    @staticmethod
    def vars_for_template(player):
        return dict(
            id = 2,
            useAI = os.getenv('AI_FIRST', 'False').lower() != 'true',
        )

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/setup-exp2')

class Task1(Page):
    """The main developer task with a split-screen setup"""
    timeout_seconds = 20*60
    template_name = 'experiment/templates/Task.html'
    
    @staticmethod
    def vars_for_template(player):
        return dict(
            useAI = os.getenv('AI_FIRST', 'True').lower() == 'true',
            id = 1,
        )

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/takedown-exp1')

class Task2(Page):
    """The main developer task with a split-screen setup"""
    timeout_seconds = 20*60
    template_name = 'experiment/templates/Task.html'
    
    @staticmethod
    def vars_for_template(player):
        return dict(
            useAI = os.getenv('AI_FIRST', 'False').lower() != 'true',
            id = 2,
        )

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/takedown-exp2')

class Break1(Page):
    """Break screen before task description"""
    timeout_seconds = 30
    template_name = 'experiment/templates/Break.html'

class Break2(Page):
    """Break screen before task description"""
    timeout_seconds = 30
    template_name = 'experiment/templates/Break.html'

class EyeCalibration1(Page):
    """Break screen before task description"""
    template_name = 'experiment/templates/EyeCalibration.html'

class EyeCalibration2(Page):
    """Break screen before task description"""
    template_name = 'experiment/templates/EyeCalibration.html'

class Survey(Page):
    """Post-task questionnaire"""
    form_model = 'player'
    form_fields = ['feedback']
    template_name = 'experiment/templates/Survey.html'

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/save-results')

page_sequence = [
    Instructions,
    EyeCalibration1,
    Break1,
    TaskDescription1,
    Task1,
    EyeCalibration2,
    Break2,
    TaskDescription2,
    Task2,
    Survey
]
