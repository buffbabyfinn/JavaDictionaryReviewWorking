<h1>Success!</h1>

#if($word)
<p>Your word has been saved.</p>
#elseif($definition)
<p>Your definition has been saved.</p>
#end

<a href="/words"><button class="btn btn-primary">View all words</button></a>
