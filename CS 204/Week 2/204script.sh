#!/bin/bash

echo "Welcome to Scripting!"
name="Emilee Forbush"

echo "Hello $name"

echo "Enter filename: "
read filename

if [ -e $filename ]; then
    echo "I am in an existing file" > $filename
else 
    touch $filename
fi

path=$(pwd)
mkdir -p $path/204BashScripting
cp $filename $path/204BashScripting/$filename
cd $path/204BashScripting
cat $filename
pwd

echo "Enter a number between 1 and 100: "
read number
if [number == 1]; then
    "\$1 has been added to your account." >> $filename
elif [number < 20]; then
    "\$$number have been added to your account" >> $filename
else
    "\$$number have been removed from your account" >> $filename

grep $number $filename
