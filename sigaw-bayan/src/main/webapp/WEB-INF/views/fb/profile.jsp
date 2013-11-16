
Facebook ID: ${profile.id}
</br>
Name: ${profile.name}
</br>
Your location: ${profile.location.name}


<form id="postToWall" action="/SigawBayan/facebook/feed" method="post">
	<input type="textarea" name="message" length="50" width="100"/>
	<button type="submit">post</button>
</form>

