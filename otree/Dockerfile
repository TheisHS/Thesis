# otree/Dockerfile
FROM python:3.10-slim

WORKDIR /app

COPY . .

RUN pip install -r requirements.txt

EXPOSE 8000

CMD ["otree", "devserver", "0.0.0.0:8000"]