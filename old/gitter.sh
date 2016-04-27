#! /bin/bash

echo "Welcome 2 Gitter 2k16" 
read -p 'Git username: ' s1
read -p 'Git Repo: ' s2
git clone https://www.github.com/$s1/$s2
read -p 'Git E-mail: ' s3
read -p 'Commit msg: ' s4

cd $s2
git config --global user.name "$s1"
git config --global user.email "$s3"
git remote -v
echo ""
echo "now add all the new files!"
echo ""
read -p "Press [Enter]"
git add *
git status -s
git commit -m "$s4"
echo "uploading..."
git push origin master
echo "done!"

