

# Check if any changes are there in the remote repository
Write-Output "Check if any changes are there in remote repo"
git pull

# Adding all local changes to commit
Write-Output "Adding all local changes to commit"
git add .
git commit -m "Content updated"

# Pushing local changes to the remote repository
Write-Output "Pushing local changes to git remote repo"
git push