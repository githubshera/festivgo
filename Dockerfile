FROM ubuntu:latest
LABEL authors="works"

ENTRYPOINT ["top", "-b"]