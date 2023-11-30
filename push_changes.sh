echo "Adding ssh key"
cd ~/.ssh/
eval "$(ssh-agent -s)"
ssh-add id_rajpiyush
echo "Moving back to working dir"
cd /g/Scaler/repo/Algorithms/
echo "Check if any changes are there in remote repo"
git pull
echo "Adding all local changes to commit"
git add .
git commit -m "Content upadated"
echo "Pusing local changes to git remote repo"
git push