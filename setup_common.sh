#!/bin/bash

projectPath=${PWD}

cd bertScala
sbt update compile
cd target/scala-2.12/classes
javah -cp /usr/local/Cellar/scala/2.12.8/libexec/lib/scala-library.jar:. EvalJNI
mv EvalJNI.h ${projectPath}/bertCpp

cd ${projectPath}/bertCpp
mkdir build
cd build
cmake -DCMAKE_PREFIX_PATH=${projectPath}/libtorch ..
make
mv libModel.* ${projectPath}
