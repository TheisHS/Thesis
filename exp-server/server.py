from flask import Flask, jsonify, request
from flask_cors import CORS, cross_origin
import subprocess
import os
from openai import OpenAI

app = Flask(__name__)
CORS(app, support_credentials=True)

@app.route('/setup-exp1')
@cross_origin(supports_credentials=True)
def setup_exp1():
    try:
        result = subprocess.run(["./setup-exp.sh", "1"], capture_output=True, text=True, check=True)
        return jsonify({"output": result.stdout})
    except subprocess.CalledProcessError as e:
        return jsonify({"error": str(e), "output": e.output}), 500
    
@app.route('/setup-exp2')
@cross_origin(supports_credentials=True)
def setup_exp2():
    try:
        result = subprocess.run(["./setup-exp.sh", "2"], capture_output=True, text=True, check=True)
        return jsonify({"output": result.stdout})
    except subprocess.CalledProcessError as e:
        return jsonify({"error": str(e), "output": e.output}), 500
    
@app.route('/run-tests')
@cross_origin(supports_credentials=True)
def run_tests():
    try:
        result = subprocess.run(["./run-tests.sh"], capture_output=True, text=True, check=True)
        return jsonify({"output": result.stdout})
    except subprocess.CalledProcessError as e:
        return jsonify({"error": "Your solution does not compile. Are the class names correct?", "output": e.output}), 200

@app.route('/takedown-exp1')
@cross_origin(supports_credentials=True)
def takedown_exp1():
    try:
        result = subprocess.run(["./takedown-exp.sh", "1"], capture_output=True, text=True, check=True)
        return jsonify({"output": result.stdout})
    except subprocess.CalledProcessError as e:
        return jsonify({"error": str(e), "output": e.output}), 500   

@app.route('/takedown-exp2')
@cross_origin(supports_credentials=True)
def takedown_exp2():
    try:
        result = subprocess.run(["./takedown-exp.sh", "2"], capture_output=True, text=True, check=True)
        return jsonify({"output": result.stdout})
    except subprocess.CalledProcessError as e:
        return jsonify({"error": str(e), "output": e.output}), 500   

@app.route('/save-results')
@cross_origin(supports_credentials=True)
def save_results():
    try:
        result = subprocess.run(["./save-results.sh"], capture_output=True, text=True, check=True)
        return jsonify({"output": result.stdout})
    except subprocess.CalledProcessError as e:
        return jsonify({"error": str(e), "output": e.output}), 500   


OPENAI_API_KEY = os.environ.get("OPENAI_API_KEY")
conversation_history = [
    {"role": "developer", "content": "You are a helpful assistant."},
]

@app.route("/chat", methods=["POST"])
@cross_origin(supports_credentials=True)
def chat():
    user_message = request.json.get("message")
    conversation_history.append({"role": "user", "content": user_message})

    client = OpenAI(
        api_key=os.environ.get("OPENAI_API_KEY"),
    )

    response = client.chat.completions.create(
        messages=conversation_history,
        model="gpt-4o-mini",
    )

    bot_reply = response.choices[0].message.content
    """ We can use this if we care about tracking token usage 
    usage = response.usage.{prompt_tokens,completions_tokens,total_tokens}"""
    conversation_history.append({"role": "assistant", "content": bot_reply})

    return jsonify({"reply": bot_reply})

if __name__ == "__main__":
    app.run(port=5000, host='0.0.0.0')