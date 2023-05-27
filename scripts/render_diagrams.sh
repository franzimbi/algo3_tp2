#!/bin/sh

diagramsPath="diagrams"

echo 'AVERTENCIA!!!'
echo
echo "Todos los archivos '*.png' dentro de \"$diagramsPath\" serán borrados."
echo "Se regeneraran a partir de los archivos '*.plantuml'."
echo

read -t 20 -n 1 -p "Desea continuar (y/N): " answer
[ -z "$answer" ] && answer="n"

if [ "$answer" == "y" ]
then
cd ..
cd diagrams
for i in classes packages sequences states
do
  cd $i
  rm *png
  plantuml -tpng *.puml
  cd ..
done
fi
