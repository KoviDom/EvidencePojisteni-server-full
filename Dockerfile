FROM ubuntu:latest
LABEL authors="domin"

ENTRYPOINT ["top", "-b"]