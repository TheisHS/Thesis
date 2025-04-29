import json
from flask import Flask, jsonify, request
from flask_cors import CORS, cross_origin
from pylsl import StreamInfo, StreamOutlet
from pynput import keyboard, mouse

app = Flask(__name__)
CORS(app, support_credentials=True)

otree_info = StreamInfo(name='oTree', type='Markers', channel_count=2, nominal_srate=0, 
                  channel_format='string', source_id='oTree123')
otree_outlet = StreamOutlet(otree_info)

gpt_info = StreamInfo(name='GPT', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='gpt123')
gpt_outlet = StreamOutlet(gpt_info)

click_info = StreamInfo(name='mouseclicklogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='mouselogger_click123')
click_outlet = StreamOutlet(click_info)

move_info = StreamInfo(name='mousemovelogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='mouselogger_move123')
move_outlet = StreamOutlet(move_info)

key_info = StreamInfo(name='keylogger', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='keylogger123')
key_outlet = StreamOutlet(key_info)

tlx_info = StreamInfo(name='NASA-TLX', type='Markers', channel_count=8, nominal_srate=0, 
                  channel_format='string', source_id='nasa-tlx123')
tlx_outlet = StreamOutlet(tlx_info)


@app.route("/send-lsl-event", methods=["POST"])
@cross_origin(supports_credentials=True)
def send_event():
  event: str = request.json.get("event")
  ai: str = request.json.get("isAI")
  print("Received event", event)
  if event.lower().startswith("gpt"):
    print("Sending GPT event", event)
    gpt_outlet.push_sample([event])
  else:
    print("Sending oTree event", event)
    otree_outlet.push_sample([event, str(ai)])
  return jsonify({"status": "success"})

@app.route("/submit-tlx", methods=["POST"])
@cross_origin(supports_credentials=True)
def submit_tlx():
  print("submit_tlx")
  taskId = request.json.get("taskId")
  useAI = request.json.get("useAI")
  formAnswers: dict[str, int] = request.json.get("formAnswers")
  print("Received NASA TLX answers, sending event", [str(taskId), str(useAI), *list(formAnswers.values())])
  tlx_outlet.push_sample([str(taskId), str(useAI), *list(formAnswers.values())])
  return jsonify({"status": "success"})


def on_move(x, y):
  move_outlet.push_sample([f"move {x},{y}"])

def on_click(x, y, button, pressed):
  if not pressed: return
  click_outlet.push_sample([f"click {x},{y} {button}"])

def on_keypress(key, pressed):
  key_outlet.push_sample([f"{key} {'down' if pressed else 'up'}"])


if __name__ == "__main__":
  with mouse.Listener(on_move=on_move, on_click=on_click) as mouselistener:
    with keyboard.Listener(on_press=lambda k: on_keypress(k, True), on_release=lambda k: on_keypress(k, False)) as keylistener:
      app.run(port=4000, host='0.0.0.0')