from pynput import keyboard
from pylsl import StreamInfo, StreamOutlet

info = StreamInfo(name='keylogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='keylogger123')
outlet = StreamOutlet(info)

def on_press(key):
  outlet.push_sample([str(key)])

with keyboard.Listener(on_press=on_press) as listener:
  listener.join()