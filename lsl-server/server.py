from flask import Flask, jsonify, request
from flask_cors import CORS, cross_origin
from pylsl import StreamInfo, StreamOutlet

app = Flask(__name__)
CORS(app, support_credentials=True)

info = StreamInfo(name='oTree', type='Markers', channel_count=1, nominal_srate=0, 
                  channel_format='string', source_id='oTree123')
outlet = StreamOutlet(info)

@app.route("/send-lsl-event", methods=["POST"])
@cross_origin(supports_credentials=True)
def send_event():
  event = request.json.get("event")
  print("Received event", event)
  outlet.push_sample([event])
  return jsonify({"status": "success"})


if __name__ == "__main__":
    app.run(port=4000, host='0.0.0.0')