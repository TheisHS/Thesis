from otree.api import *
import requests, os

_DEBUG = os.getenv('DEBUG', 'False').lower() == 'true'

class DebugPage(Page):
    @staticmethod
    def js_vars(player):
        return dict(debug = _DEBUG)

class Empty(DebugPage):
    template_name = 'experiment/templates/Empty.html'

class TestSetup(DebugPage):
    template_name = 'experiment/templates/TestSetup.html'

class Instructions(DebugPage):
    template_name = 'experiment/templates/Instructions.html'

#
# FIRST TASK
# 

class FirstPages(Page):
    """abstract class for the pages for the first task"""
    @staticmethod
    def js_vars(player):
        return dict(
            id = 1,
            useAI = os.getenv('AI_FIRST', 'True').lower() == 'true',
            debug = _DEBUG,
        )
    
    @staticmethod
    def vars_for_template(player):
        return dict(
            id = 1,
            useAI = os.getenv('AI_FIRST', 'True').lower() == 'true',
        )

class EyeCalibration1(FirstPages):
    """Break screen before task description"""
    template_name = 'experiment/templates/EyeCalibration.html'

class Break1(FirstPages):
    """Break screen before task description"""
    timeout_seconds = 30
    template_name = 'experiment/templates/Break.html'

class TaskDescription1(FirstPages):
    timeout_seconds = 2*60
    template_name = 'experiment/templates/TaskDescriptionPage.html'

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/setup-exp1')

class Task1(FirstPages):
    """The main developer task with a split-screen setup"""
    timeout_seconds = 20*60
    template_name = 'experiment/templates/Task.html'

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/takedown-exp1')

class TLX1(FirstPages):
    """NASA TLX"""
    template_name = 'experiment/templates/NASA-TLX.html'


#
# SECOND TASK
# 

class SecondPages(Page):
    """abstract class for the pages for the second task"""
    @staticmethod
    def js_vars(player):
        return dict(
            id = 2,
            useAI = os.getenv('AI_FIRST', 'False').lower() != 'true',
            debug = _DEBUG,
        )
    
    @staticmethod
    def vars_for_template(player):
        return dict(
            id = 2,
            useAI = os.getenv('AI_FIRST', 'False').lower() != 'true',
        )

class EyeCalibration2(SecondPages):
    """Break screen before task description"""
    template_name = 'experiment/templates/EyeCalibration.html'

class Break2(SecondPages):
    """Break screen before task description"""
    timeout_seconds = 30
    template_name = 'experiment/templates/Break.html'

class TaskDescription2(SecondPages):
    timeout_seconds = 2*60
    template_name = 'experiment/templates/TaskDescriptionPage.html'

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/setup-exp2')

class Task2(SecondPages):
    """The main developer task with a split-screen setup"""
    timeout_seconds = 20*60
    template_name = 'experiment/templates/Task.html'

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/takedown-exp2')

class TLX2(SecondPages):
    """NASA TLX"""
    template_name = 'experiment/templates/NASA-TLX.html'

#
# END
#

class End(DebugPage):
    """Post-task questionnaire"""
    template_name = 'experiment/templates/End.html'

    @staticmethod
    def before_next_page(player, timeout_happened):
        requests.get('http://host.docker.internal:5000/save-results')


page_sequence = [
    Empty,
    TestSetup,
    Instructions,
    EyeCalibration1,
    Break1,
    TaskDescription1,
    Task1,
    TLX1,
    EyeCalibration2,
    Break2,
    TaskDescription2,
    Task2,
    TLX2,
    End
]
