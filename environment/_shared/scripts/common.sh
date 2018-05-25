#!/bin/bash

# dove vengono montate le risorse e i download condivisi 
PROJECT_HOME=/home/progetto
PROJECT_DOWNLOADS=${PROJECT_HOME}/_shared/downloads
PROJECT_RESOURCES=${PROJECT_HOME}/_shared/resources

function resourceExists {
	FILE=${PROJECT_RESOURCES}/$1
	if [ -e $FILE ]
	then
		return 0
	else
		return 1
	fi
}

function downloadExists {
	FILE=${PROJECT_DOWNLOADS}/$1
	if [ -e $FILE ]
	then
		return 0
	else
		return 1
	fi
}

function fileExists {
	FILE=$1
	if [ -e $FILE ]
	then
		return 0
	else
		return 1
	fi
}

#echo "common loaded"
