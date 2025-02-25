from flask import Flask, jsonify
import subprocess

app = Flask(__name__)

@app.route('/run-script')
def run_script():
    try:
        result = subprocess.run(["./script.sh"], capture_output=True, text=True, check=True)
        return jsonify({"output": result.stdout})
    except subprocess.CalledProcessError as e:
        return jsonify({"error": str(e), "output": e.output}), 500

if __name__ == "__main__":
    app.run(port=5000, host='0.0.0.0')