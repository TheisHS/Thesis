# Testserver/Dockerfile
FROM naddinadja/jdk-python:latest

WORKDIR /app

COPY . .

# Remove Windows line endings in shell scripts
RUN for f in *.sh ; do sed -i -e 's/\r$//' $f ; done

# RUN apt-get update && apt-get install ./liblsl-1.16.2-focal_amd64.deb -y

RUN pip install -r requirements.txt

EXPOSE 5000

CMD ["python3", "-u", "testserver.py"]