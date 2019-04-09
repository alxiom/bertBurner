#!/bin/bash

projectPath=${PWD}

cd ${projectPath}/bertCpp
rm -rf build
mkdir build
cd build
cmake -DCMAKE_PREFIX_PATH=${projectPath}/libtorch ..
make
mv libModel.* ${projectPath}

cd ${projectPath}/bertScala
sbt universal:packageBin
mv ${projectPath}/bertScala/target/universal/bertburner-0.1.0.zip ${projectPath}

cd ${projectPath}
rm -rf burner
unzip bertburner-0.1.0.zip
rm bertburner-0.1.0.zip
mv bertburner-0.1.0 burner

echo [finished] burner created
