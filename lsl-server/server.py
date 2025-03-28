from flask import Flask, jsonify, request
from flask_cors import CORS, cross_origin
from pylsl import StreamInfo, StreamOutlet
from pynput import keyboard, mouse

app = Flask(__name__)
CORS(app, support_credentials=True)

otree_info = StreamInfo(name='oTree', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='oTree123')
otree_outlet = StreamOutlet(otree_info)

click_info = StreamInfo(name='mouseclicklogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='mouselogger_click123')
click_outlet = StreamOutlet(click_info)

move_info = StreamInfo(name='mousemovelogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='mouselogger_move123')
move_outlet = StreamOutlet(move_info)

key_info = StreamInfo(name='keylogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='keylogger123')
key_outlet = StreamOutlet(key_info)


@app.route("/send-lsl-event", methods=["POST"])
@cross_origin(supports_credentials=True)
def send_event():
  event = request.json.get("event")
  print("Received event", event)
  otree_outlet.push_sample([event])
  return jsonify({"status": "success"})


def on_move(x, y):
  move_outlet.push_sample([f"move {x},{y}"])

def on_click(x, y, button, pressed):
  if not pressed: return
  click_outlet.push_sample([f"click {x},{y} {button}"])

def on_keypress(key):
  key_outlet.push_sample([str(key)])


if __name__ == "__main__":
    mouselistener = mouse.Listener(on_move=on_move, on_click=on_click)
    keylistener = keyboard.Listener(on_press=on_keypress)
    app.run(port=4000, host='0.0.0.0')