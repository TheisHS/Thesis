from pynput import mouse
from pylsl import StreamInfo, StreamOutlet

info = StreamInfo(name='mouselogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='mouselogger123')
outlet = StreamOutlet(info)

def on_move(x, y):
  outlet.push_sample([f"move {x},{y}"])

def on_click(x, y, button, pressed):
  if not pressed: return
  outlet.push_sample([f"click {x},{y} {button}"])

with mouse.Listener(on_move=on_move, on_click=on_click) as listener:
  listener.join()