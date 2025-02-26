from flask import Flask, jsonify
from flask_cors import CORS, cross_origin
import subprocess

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
        return jsonify({"error": "Your solution does not compile.", "output": e.output}), 200

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


if __name__ == "__main__":
    app.run(port=5000, host='0.0.0.0')