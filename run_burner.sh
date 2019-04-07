#!/bin/bash

mkdir -p ${HOME}/tmp

binPath=./burner/bin/bertburner

source burner.config

${binPath} -Dlogback.configurationFile=logback-http.xml -Dport=${port} -Dmodel_path=${modelPath} -Dlib_path=${libPath} -Dfile.encoding=UTF-8 -Djava.io.tmpdir=${HOME}/tmp -J-Xms${memory}G -J-Xmx${memory}G -J-XX:+UseG1GC -J-server
