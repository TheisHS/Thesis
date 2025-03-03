# Testserver/Dockerfile
FROM naddinadja/jdk-python:latest

WORKDIR /app

COPY . .

RUN pip install openai

EXPOSE 5000

CMD ["python3", "-u", "testserver.py"]