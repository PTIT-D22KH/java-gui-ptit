#!/bin/bash

# Save the current directory
current_dir=$(pwd)

# Check if the 'code' command is available
if ! command -v code &> /dev/null
then
    echo "'code' command could not be found"
    exit
fi

if [ -d "$1" ]; then
    cd $1
    count=$(ls -1 $1*.java 2>/dev/null | wc -l)
    filename=$1_$count.java

    touch $filename
    # Use the directory name as the package name
    echo "package $1;" >> $filename
    echo "" >> $filename
    echo "public class $1_$count {" >> $filename
    echo "    public static void main(String[] args) {" >> $filename
    echo "        // Write your code here" >> $filename
    echo "    }" >> $filename
    echo "}" >> $filename

    code $filename
else
    mkdir -p $1
    cd $1
    touch $1.java input.txt output.txt

    echo "## $1" >> README.md
    # Use the directory name as the package name
    echo "package $1;" >> $1.java
    echo "" >> $1.java
    echo "public class $1 {" >> $1.java
    echo "    public static void main(String[] args) {" >> $1.java
    echo "        // Write your code here" >> $1.java
    echo "    }" >> $1.java
    echo "}" >> $1.java

    code $1.java
fi

# Go back to the original directory
cd $current_dir