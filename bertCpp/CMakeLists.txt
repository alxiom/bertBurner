cmake_minimum_required(VERSION 3.0 FATAL_ERROR)
project(bertBurner)

include_directories(/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/include)
include_directories(/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/include/darwin)

find_package(Torch REQUIRED)

add_library(Model SHARED Model-BERT.cpp)
target_link_libraries(Model "${TORCH_LIBRARIES}")
set_property(TARGET Model PROPERTY CXX_STANDARD 11)
