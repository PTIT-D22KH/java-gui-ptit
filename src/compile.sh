#!/bin/bash
# Get the directory of the Java file
dir=$(dirname -- "$1")

# Get the base name of the Java file
filename=$(basename -- "$1")
filename="${filename%.*}"

# Compile the Java file
javac "$1"

# If compilation was successful, run the Java program
if [ $? -eq 0 ]; then
    # Assuming the directory structure represents the package name,
    # and considering the directory as part of the classpath.
    # The class name is specified without the .java extension and without the directory path.
    # Adjust the classpath (-cp) to include the root directory of your class files if necessary.
    cd "$dir/.." # Move up to include 'dsa01001' as part of the classpath
    java -cp "." "$filename/$filename" < "$filename/input.txt"
fi